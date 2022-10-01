package com.omnisilica.mymovieselection.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="mms_user")
public class MMSUser {
	
	@Id
	@Column(name="mmsuser_email", unique=true)
	@NotBlank(message = "This field is required.")
	@Email(message = "Please enter a valid e-mail address.")
	private String mmsUserEmail;
	
	@Column(name="mmsuser_username", unique=true)
	@NotBlank(message = "This field is required.")
	private String mmsUserUsername;
	
	@Column(name="mmsuser_password", unique=true)
	@NotBlank(message = "This field is required.")
	//@Size(min = 5, message = "{Size.Person.FullName}")
	private String mmsUserPassword;

	public MMSUser() {}

	public MMSUser(String mmsUserEmail, String mmsUserUsername, String mmsUserPassword) {
		super();
		this.mmsUserUsername = mmsUserEmail;
		this.mmsUserUsername = mmsUserUsername;
		this.mmsUserPassword = mmsUserPassword;
	}

	public String getmmsUserEmail() {
		return mmsUserEmail;
	}

	public void setmmsUserEmail(String mmsUserEmail) {
		this.mmsUserEmail = mmsUserEmail;
	}

	public String getmmsUserUsername() {
		return mmsUserUsername;
	}

	public void setmmsUserUsername(String mmsUserUsername) {
		this.mmsUserUsername = mmsUserUsername;
	}

	public String getmmsUserPassword() {
		return mmsUserPassword;
	}

	public void setmmsUserPassword(String mmsUserPassword) {
		this.mmsUserPassword = mmsUserPassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mmsUserEmail, mmsUserPassword, mmsUserUsername);
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
		return Objects.equals(mmsUserEmail, other.mmsUserEmail)
				&& Objects.equals(mmsUserPassword, other.mmsUserPassword)
				&& Objects.equals(mmsUserUsername, other.mmsUserUsername);
	}
	
	


}
