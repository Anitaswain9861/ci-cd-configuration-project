package com.login.register.rest.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.register.rest.api.entity.User;

public interface UserRepository   extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);
	 


}
