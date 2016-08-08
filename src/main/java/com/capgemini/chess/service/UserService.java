package com.capgemini.chess.service;

import com.capgemini.chess.service.to.UserProfileTO;

public interface UserService {
	UserProfileTO readUser(long id); 
}
