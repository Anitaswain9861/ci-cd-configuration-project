package com.login.register.rest.api.Service;

import com.login.register.rest.api.entity.User;

public interface UserService {
	User registerUser(User user);
    User loginUser(String username, String password);

}
