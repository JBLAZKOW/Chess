package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exception.NoSuchUserException;
import com.capgemini.chess.service.Administration;
import com.capgemini.chess.service.dao.UserDao;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class AdministrationImpl implements Administration {
	@Autowired
	private UserDao userDao;
	@Override
	public UserProfileTO getUserById(long id) throws NoSuchUserException {
		UserEntity userEntity = userDao.getUserById(id);
		return UserProfileMapper.map(userEntity);
	}

	@Override
	public UserProfileTO getUserByFirstName(String FirstName) throws NoSuchUserException {
		UserEntity userEntity = userDao.getUserByFirstName(FirstName);
		return UserProfileMapper.map(userEntity);
	}

	@Override
	public UserProfileTO getUserByLastName(String LastName) throws NoSuchUserException {
		UserEntity userEntity = userDao.getUserByLastName(LastName);
		return UserProfileMapper.map(userEntity);
	}

	@Override
	public UserProfileTO updateUser(UserProfileTO user) throws NoSuchUserException {
		UserEntity userEntity = UserProfileMapper.map(user);
		userDao.updateUser(userEntity);
		return user;
	}

	@Override
	public void deleteProfile(UserProfileTO user) throws NoSuchUserException {
		UserEntity userEntity = UserProfileMapper.map(user);
		userDao.deleteUser(userEntity);
	}

}
