package com.login.register.rest.api.Controller;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.login.register.rest.api.Repository.UserRepository;
import com.login.register.rest.api.Service.UserService;
import com.login.register.rest.api.entity.User;



@RestController
public class UserController {
	 private final UserService userService;

	    public UserController(UserService userService) {
	        this.userService = userService;
	    }

	    @PostMapping("/register")
	    public ResponseEntity<User> registerUser(@RequestBody User user) {
	        User registeredUser = userService.registerUser(user);
	        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
	    }

	    @PostMapping("/login")
	    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
	        User user = userService.loginUser(username, password);
	        if (user != null) {
	            return new ResponseEntity<>("Login successful", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
	        }
	    }
        
}

