package com.heymart.authenticate.controller;

import com.heymart.authenticate.dto.VerifyRequest;
import com.heymart.authenticate.service.auth.JwtService;
import com.heymart.authenticate.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    JwtService jwtService;

    @Autowired
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> getUser(
            HttpServletRequest request, @RequestBody VerifyRequest action
    ) {
            String authHeader = request.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No token provided.");
            }
            String token = authHeader.substring(7);
            String username = jwtService.extractUsername(token);
            if (username == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token does not contain a valid username.");
            }

            return ResponseEntity.ok(userService.findByUsername(username));

    }

}
