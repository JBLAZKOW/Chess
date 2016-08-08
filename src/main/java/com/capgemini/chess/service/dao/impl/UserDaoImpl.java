package com.capgemini.chess.service.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exception.NoSuchUserException;
import com.capgemini.chess.service.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	//stub
	private Set<UserEntity> users = new HashSet<UserEntity>();
	
	public UserDaoImpl() {
		createSampleUsers();
	}
	
	@Override
	public UserEntity addUser(UserEntity user) {
		users.add(user);
		return user;
	}

	@Override
	public UserEntity getUserById(long id) throws NoSuchUserException {
		for (UserEntity user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		throw new NoSuchUserException();
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return new ArrayList<UserEntity>(users);
	}

	@Override
	public UserEntity updateUser(UserEntity user) throws NoSuchUserException {
		UserEntity userToUpdate = getUserById(user.getId());
		users.remove(userToUpdate);
		users.add(user);		
		return user;
	}

	@Override
	public void deleteUser(UserEntity user) throws NoSuchUserException {
		UserEntity userToDelete = getUserById(user.getId());
		users.remove(userToDelete);
	}
	
	@Override
	public UserEntity getUserByFirstName(String firstName) throws NoSuchUserException {
		for (UserEntity user : users) {
			if (user.getName().equals(firstName)) {
				return user;
			}
		}
		throw new NoSuchUserException();
	} 

	@Override
	public UserEntity getUserByLastName(String lastName) throws NoSuchUserException {
		for (UserEntity user : users) {
			if (user.getSurname().equals(lastName)) {
				return user;
			}
		}
		throw new NoSuchUserException();
	}
	
	private void createSampleUsers() {
		users.add(new UserEntity(112L, "John", "Doe"));
		users.add(new UserEntity(1050L, "John", "Fox"));
		users.add(new UserEntity(991L, "A" , "B"));
		users.add(new UserEntity(5L , "Lis", "Dis"));
		users.add(new UserEntity(33L, "User", "User"));
	}
}
