package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.exception.NoSuchUserException;
import com.capgemini.chess.service.to.UserProfileTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AdministrationServiceTest {
	@Autowired
	Administration administrationService;

	@ComponentScan
	@Configuration
	static class TestContextConfiguration {
	}

	@Test
	public void shouldFindExistingPlayerById() throws NoSuchUserException {
		// when
		UserProfileTO user = administrationService.getUserById(5L);
		assertNotNull(user);
	}

	@Test(expected = NoSuchUserException.class)
	public void shouldNotFindNotExistingPlayer() throws NoSuchUserException {
		// when
		administrationService.getUserById(5890L);
	}

	@Test
	public void shouldFindExistingPlayerByFirstname() throws NoSuchUserException {
		// when
		UserProfileTO user = administrationService.getUserByFirstName("A");
		assertNotNull(user);
	}

	@Test
	public void shouldFindExistingPlayerByLastname() throws NoSuchUserException {
		// when
		UserProfileTO user = administrationService.getUserByLastName("B");
		assertNotNull(user);
	}

	@Test
	public void shouldChangeAboutMeForExistingUser() throws NoSuchUserException {
		// given
		String aboutMe = "I'm 23.";
		// when
		UserProfileTO user = administrationService.getUserById(33L);
		user.setAboutMe(aboutMe);
		UserProfileTO changedUser = administrationService.updateUser(user);
		// then
		assertEquals(aboutMe, changedUser.getAboutMe());
	}
	@Test
	public void shouldChangeLifeMottoForExistingUser() throws NoSuchUserException {
		// given
		String motto = "Play hard or go home";
		// when
		UserProfileTO user = administrationService.getUserById(5L);
		user.setLifeMotto(motto);
		UserProfileTO changedUser = administrationService.updateUser(user);
		// then
		assertEquals(motto, changedUser.getLifeMotto());
	}
	@Test
	public void shouldChangeUserEmailForExistingUser() throws NoSuchUserException {
		// given
		String email = "mail@gmail.com";
		// when
		UserProfileTO user = administrationService.getUserById(5L);
		user.setEmail(email);
		UserProfileTO changedUser = administrationService.updateUser(user);
		// then
		assertEquals(email, changedUser.getEmail());
	}
	@Test
	public void shouldChangeUserFirstNameForExistingUser() throws NoSuchUserException {
		// given
		String name = "Jurek";
		// when
		UserProfileTO user = administrationService.getUserById(112L);
		user.setName(name);
		UserProfileTO changedUser = administrationService.updateUser(user);
		// then
		assertEquals(name, changedUser.getName());
	}
	@Test
	public void shouldChangeUserLastNameForExistingUser() throws NoSuchUserException {
		// given
		String surname = "Jurkiewicz";
		// when
		UserProfileTO user = administrationService.getUserById(112L);
		user.setSurname(surname);
		UserProfileTO changedUser = administrationService.updateUser(user);
		// then
		assertEquals(surname, changedUser.getSurname());
	}
	@Test (expected = NoSuchUserException.class)
	public void shouldDeleteExistingUser() throws NoSuchUserException {
		// when
		UserProfileTO user = administrationService.getUserById(1050L);
		administrationService.deleteProfile(user);
		administrationService.getUserById(1050L);
	}
}
