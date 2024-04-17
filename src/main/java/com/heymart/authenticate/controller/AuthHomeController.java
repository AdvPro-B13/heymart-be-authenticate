package com.heymart.authenticate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthHomeController {

    @GetMapping("/")
    public String home() {
        return "AuthHomePage";
    }
}
