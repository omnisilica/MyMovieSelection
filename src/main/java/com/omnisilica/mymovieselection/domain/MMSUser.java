package com.omnisilica.mymovieselection.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mms_user")
public class MMSUser {
	
	@Id
	@Column(name="mmsuser_email", unique=true)
	private String mmsuserEmail;
	
	@Column(name="mmsuser_username", unique=true)
	private String userUsername;
	
	@Column(name="mmsuser_password", unique=true)
	private String userPassword;

	public MMSUser() {}

	public MMSUser(String mmsuserEmail, String userUsername, String userPassword) {
		super();
		this.mmsuserEmail = mmsuserEmail;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
	}

	public String getMmsuserEmail() {
		return mmsuserEmail;
	}

	public void setMmsuserEmail(String mmsuserEmail) {
		this.mmsuserEmail = mmsuserEmail;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mmsuserEmail, userPassword, userUsername);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MMSUser)) {
			return false;
		}
		MMSUser other = (MMSUser) obj;
		return Objects.equals(mmsuserEmail, other.mmsuserEmail) && Objects.equals(userPassword, other.userPassword)
				&& Objects.equals(userUsername, other.userUsername);
	}

}
