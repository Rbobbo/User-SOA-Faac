package it.faac.dto;

import java.io.Serializable;

public class UserLoginRequestDTO implements Serializable
{
	private static final long serialVersionUID = -8135096905598862673L;
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
