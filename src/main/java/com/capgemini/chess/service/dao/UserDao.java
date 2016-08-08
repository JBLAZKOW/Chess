package com.capgemini.chess.service.dao;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exception.NoSuchUserException;

/**
 * @author JBLAZKOW
 *
 */
public interface UserDao {

	/**
	 * @return all users
	 */
	List<UserEntity> getAllUsers();
	/**
	 * @param user to add
	 * @return added user
	 */
	UserEntity addUser(UserEntity user);
	/**
	 * @param user to delete
	 * @throws NoSuchUserException
	 */
	void deleteUser(UserEntity user) throws NoSuchUserException;
	/**
	 * @param user to update
	 * @return updated user
	 * @throws NoSuchUserException
	 */
	UserEntity updateUser(UserEntity user) throws NoSuchUserException;
	/**
	 * @param id of searched user
	 * @return found user
	 * @throws NoSuchUserException
	 */
	UserEntity getUserById(long id) throws NoSuchUserException;
	/**
	 * @param firstName of searched user
	 * @return found user 
	 * @throws NoSuchUserException
	 */
	UserEntity getUserByFirstName(String firstName) throws NoSuchUserException;
	/**
	 * @param lastName of searched user
	 * @return found user
	 * @throws NoSuchUserException
	 */
	UserEntity getUserByLastName(String lastName) throws NoSuchUserException;
	
}
