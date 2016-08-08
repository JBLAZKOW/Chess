package com.capgemini.chess.service.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProfileTO {

	private long id;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String aboutMe;
	private String lifeMotto;

	public UserProfileTO() {
	}

	private UserProfileTO(Builder builder) {
		this.id = builder.id;
		this.login = builder.login;
		this.password = builder.password;
		this.name = builder.name;
		this.surname = builder.surname;
		this.email = builder.email;
		this.aboutMe = builder.aboutMe;
		this.lifeMotto = builder.lifeMotto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getLifeMotto() {
		return lifeMotto;
	}

	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}

	public static class Builder {
		private final long id;
		private String login;
		private String password;
		private String name;
		private String surname;
		private String email;
		private String aboutMe;
		private String lifeMotto;

		public Builder(long id) {
			this.id = id;
		}

		public Builder login(String login) {
			this.login = login;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder surname(String surname) {
			this.surname = surname;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder lifeMotto(String motto) {
			this.lifeMotto = motto;
			return this;
		}

		public Builder aboutMe(String aboutMe) {
			this.aboutMe = aboutMe;
			return this;
		}

		public UserProfileTO build() {
			return new UserProfileTO(this);
		}

	}
}
