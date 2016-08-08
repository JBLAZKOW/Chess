package com.capgemini.chess.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.chess.exception.NoSuchUserException;
import com.capgemini.chess.service.Administration;
import com.capgemini.chess.service.to.UserProfileTO;

/**
 * @author JBLAZKOW
 * REST Service for Administration
 */
@Controller
@ResponseBody
public class AdministrationRestService {

	@Autowired
	private Administration administration;

	/**
	 * @param id of searched user
	 * @return found user profile
	 * @throws NoSuchUserException
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public final UserProfileTO findUserById(@RequestParam("id") final long id) 
			throws NoSuchUserException {
		return administration.getUserById(id);
	}
	
	/**
	 * @param firstname of searched user
	 * @return found user profile
	 * @throws NoSuchUserException
	 */
	@RequestMapping(value = "/findByFirstname", method = RequestMethod.GET)
	public final UserProfileTO findUserByFirstname(@RequestParam("firstname") final String firstname) 
			throws NoSuchUserException {
		return administration.getUserByFirstName(firstname);
	}
	
	/**
	 * @param surname of searched user
	 * @return found user profile
	 * @throws NoSuchUserException
	 */
	@RequestMapping(value = "/findBySurname", method = RequestMethod.GET)
	public final UserProfileTO findUserBySurname(@RequestParam("surname") final String surname) 
			throws NoSuchUserException {
		return administration.getUserByLastName(surname);
	}
	
	/**
	 * @param user to update
	 * @return updated user
	 * @throws NoSuchUserException
	 */
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public final UserProfileTO updateUser(@RequestBody final UserProfileTO user) 
			throws NoSuchUserException {
		return administration.updateUser(user);
	}

	/**
	 * @param user to delete
	 * @throws NoSuchUserException
	 */
	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	public final void deleteUser(@RequestBody final UserProfileTO user) throws NoSuchUserException {
		administration.deleteProfile(user);
	}
}
