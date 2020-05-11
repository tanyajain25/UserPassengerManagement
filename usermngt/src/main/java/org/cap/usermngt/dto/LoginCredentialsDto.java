package org.cap.usermngt.dto;

import java.math.BigInteger;

public class LoginCredentialsDto {
	
	private BigInteger userId;
	private String password;

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
