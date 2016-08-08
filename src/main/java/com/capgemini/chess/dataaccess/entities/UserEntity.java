package com.capgemini.chess.dataaccess.entities;

public class UserEntity {

	private long id;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String aboutMe;
	private String lifeMotto;

	public UserEntity() {
		
	}
	public UserEntity(final long id) {
		this.id = id;
	}
	public UserEntity(final long id, final String name, final String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname; 
	}
	public final long getId() {
		return id;
	}

	public final void setId(final long id) {
		this.id = id;
	}

	public final String getLogin() {
		return login;
	}

	public final void setLogin(final String login) {
		this.login = login;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(final String password) {
		this.password = password;
	}

	public final String getName() {
		return name;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public final String getSurname() {
		return surname;
	}

	public final void setSurname(final String surname) {
		this.surname = surname;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(final String email) {
		this.email = email;
	}

	public final String getAboutMe() {
		return aboutMe;
	}

	public final void setAboutMe(final String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public final String getLifeMotto() {
		return lifeMotto;
	}

	public final void setLifeMotto(final String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}

}
