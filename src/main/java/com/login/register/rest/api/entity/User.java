package com.login.register.rest.api.entity;

import org.hibernate.annotations.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class User {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private String userName;
	    @Column(nullable = false, unique = true)
	    private String email;
	    @Column(nullable = false)
	    private String password;
	    
	    public Integer getId() {
	          return id;
	      }
	      public void setId(Integer id) {
	          this.id = id;
	      }
	     
	      public String getUserName() {
	          return userName;
	      }
	      public void setUserName(String username) {
	          this.userName = username;
	      }
	      public String getEmail() {
	          return email;
	      }
	      public void setEmail(String email) {
	          this.email = email;
	      }
	      public String getPassword() {
	          return password;
	      }
	      public void setPassword(String password) {
	          this.password = password;
	      }
	      
	}


