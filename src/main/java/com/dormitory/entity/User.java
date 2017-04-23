package com.dormitory.entity;

import java.security.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public abstract class User {
	@NotEmpty(message = "{user.name.null}")
	@Length(min = 5, max = 20, message = "{user.name.length.illegal}")
	@Pattern(regexp = "[a-zA-Z]{5,20}", message = "{user.name.illegal}")
	protected String name;
	@NotNull(message = "{user.phoneNumber.null}")
	//@Length(min = 11, max = 11, message = "{user.phoneNumber.length.illegal}")
	//@Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$", message = "{user.phoneNumber.illegal}")
	protected Long phoneNumber;
	@NotEmpty(message = "{user.email.null}")
	@Length(min =5, max = 50, message = "{user.email.length.illegal}")
	@Pattern(regexp = "^[A-Za-z0-9"+"\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$ ", message = "{user.email.illegal}")
	protected String email;
	@NotEmpty(message = "{user.password.null}")
	@Length(min = 5, max = 20, message = "{user.password.length.illegal}")
	@Pattern(regexp = "[a-zA-Z]{5,20}", message = "{user.password.illegal}")
	protected String password;

	protected Timestamp outDate;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Timestamp getOutDate() {
		return outDate;
	}

	public void setOutDate(Timestamp outDate) {
		this.outDate = outDate;
	}

}
