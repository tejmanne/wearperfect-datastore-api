package com.wearperfect.datastoreapi.service;

import com.wearperfect.datastoreapi.models.User;

public interface UserService {
	
	public User getUserDetails(Long userId);
	
	public User getUserDetails(String username);
}
