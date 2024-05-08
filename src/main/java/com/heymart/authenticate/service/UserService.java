package com.heymart.authenticate.service;

import com.heymart.authenticate.model.Customer;
import com.heymart.authenticate.model.Manager;
import com.heymart.authenticate.model.User;
import com.heymart.authenticate.repository.CustomerRepository;
import com.heymart.authenticate.repository.ManagerRepository;
import com.heymart.authenticate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository<User> userRepository;
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username).get();

        return user;
    }
}
