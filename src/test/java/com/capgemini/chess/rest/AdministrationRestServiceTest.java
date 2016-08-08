package com.capgemini.chess.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capgemini.chess.fileutils.FileUtils;
import com.capgemini.chess.service.Administration;
import com.capgemini.chess.service.to.UserProfileTO;

/**
 * @author JBLAZKOW
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class AdministrationRestServiceTest {
	@Autowired
	private Administration administration;
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public final void setUp() {
		Mockito.reset(administration);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public final void testShouldFindUserByID() throws Exception {
		// given
		final UserProfileTO user = new UserProfileTO.Builder(1L).login("johnDoe123")
				.name("John").surname("Doe").email("johnDoe@example.com").build();
		Mockito.when(administration.getUserById(Mockito.anyLong())).thenReturn(user);
		// when
		ResultActions response = this.mockMvc.perform(get("/findById").param("id", 
				Long.toString(user.getId()))
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
				.content("1"));
		// then
		response.andExpect(status().isOk()).andExpect(jsonPath(".id").value((int) user.getId()))
				.andExpect(jsonPath(".login").value(user.getLogin()))
				.andExpect(jsonPath(".name").value(user.getName()))
				.andExpect(jsonPath(".surname").value(user.getSurname()));
	}

	@Test
	public final void testShouldFindUserByFirstname() throws Exception {
		// given
		final UserProfileTO user = new UserProfileTO.Builder(1L).login("johnDoe123")
				.name("John").surname("Doe").email("johnDoe@example.com").build();
		Mockito.when(administration.getUserByFirstName(Mockito.any())).thenReturn(user);
		// when
		ResultActions response = this.mockMvc.perform(get("/findByFirstname")
				.param("firstname", user.getName())
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
				.content("1"));
		// then
		response.andExpect(status().isOk()).andExpect(jsonPath(".id").value((int) user.getId()))
				.andExpect(jsonPath(".login").value(user.getLogin()))
				.andExpect(jsonPath(".name").value(user.getName()))
				.andExpect(jsonPath(".surname").value(user.getSurname()));
	}

	@Test
	public final void testShouldFindUserBySurname() throws Exception {
		// given
		final UserProfileTO user = new UserProfileTO.Builder(1L).login("johnDoe123")
				.name("John").surname("Doe")
				.email("johnDoe@example.com").build();
		Mockito.when(administration.getUserByLastName(Mockito.any())).thenReturn(user);
		// when
		ResultActions response = this.mockMvc.perform(get("/findBySurname")
				.param("surname", user.getSurname())
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
				.content("1"));
		// then
		response.andExpect(status().isOk()).andExpect(jsonPath(".id").value((int) user.getId()))
				.andExpect(jsonPath(".login").value(user.getLogin()))
				.andExpect(jsonPath(".name").value(user.getName()))
				.andExpect(jsonPath(".surname").value(user.getSurname()));
	}

	@Test
	public final void testShouldUpdateUser() throws Exception {
		// given
		File file = FileUtils.getFileFromClasspath("classpath:com/capgemini/chess/json/UserProfile.json");
		String json = FileUtils.readFileToString(file);
		// when
		ResultActions response = this.mockMvc.perform(put("/user").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(json.getBytes()));
		// then
		Mockito.verify(administration).updateUser(Mockito.any());
		response.andExpect(status().isOk());
	}

	@Test
	public final void testShouldDeleteUser() throws Exception {
		// given
		File file = FileUtils.getFileFromClasspath("classpath:com/capgemini/chess/json/UserProfile.json");
		String json = FileUtils.readFileToString(file);
		// when
		ResultActions response = this.mockMvc.perform(delete("/user").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(json.getBytes()));
		// then
		Mockito.verify(administration).deleteProfile(Mockito.any());
		response.andExpect(status().isOk());
	}
}
