package com.capgemini.chess.service;

import com.capgemini.chess.exception.NoSuchUserException;
import com.capgemini.chess.service.to.UserProfileTO;
/*
 * As an administrator I want the application shows user profiles to be able to update or delete them.
•	As an administrator I want to search for user profiles by user id or user first name or user last name.
•	As an administrator I want to be able to change user first name, user last name, email address, about me note and life motto
*/
/**
 * @author JBLAZKOW
 *  Administration is a service responsible for making changes with user profiles in application.
 */
public interface Administration {
	
	/**
	 * @param id of searched user
	 * @return UserProfile found with id
	 * @throws NoSuchUserException
	 */
	public UserProfileTO getUserById(long id) throws NoSuchUserException;
	
	/**
	 * @param firstName of searched user
	 * @return UserProfile found with firstName
	 * @throws NoSuchUserException
	 */
	public UserProfileTO getUserByFirstName(String firstName) throws NoSuchUserException;
	
	/**
	 * @param lastName of searched user
	 * @return UserProfile found with lastName
	 * @throws NoSuchUserException
	 */
	public UserProfileTO getUserByLastName(String lastName) throws NoSuchUserException;

	/**
	 * @param user to change
	 * @param firstName to set
	 * @return UserProfile with changed name
	 * @throws NoSuchUserException
	 */
	public UserProfileTO updateUser(UserProfileTO user) throws NoSuchUserException;
	
	/**
	 * @param user to delete
	 * @throws NoSuchUserException
	 */
	public void deleteProfile(UserProfileTO user) throws NoSuchUserException;
}
