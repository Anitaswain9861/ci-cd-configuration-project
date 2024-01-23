package com.login.register.rest.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.register.rest.api.Repository.UserRepository;
import com.login.register.rest.api.Service.UserService;
import com.login.register.rest.api.entity.User;
@Service
public class UserServiceImplementor  implements UserService{
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Override
	    public User registerUser(User user) {
	        // Hash the password before saving it to the database
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        return userRepository.save(user);
	    }

	    @Override
	    public User loginUser(String username, String password) {
	        // Logic for validating login credentials
	        User user = userRepository.findByUsername(username);
	        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
	            return user;
	        }
	        return null; // Invalid credentials
	    }
}
