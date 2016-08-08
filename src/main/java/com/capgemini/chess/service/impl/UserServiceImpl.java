package com.capgemini.chess.service.impl;

import com.capgemini.chess.service.UserService;
import com.capgemini.chess.service.to.UserProfileTO;

public class UserServiceImpl implements UserService {

	@Override
	public UserProfileTO readUser(long id) {
		return new UserProfileTO();
	}

}
