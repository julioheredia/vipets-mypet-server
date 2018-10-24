package com.vipets.mypet.vipetsmypetserver.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Credentials {

	private String email;
	private String password;
	private String token;

	@JsonCreator
	public Credentials() {
		super();
	}

	@JsonCreator
	public Credentials(@JsonProperty("email") String email, @JsonProperty("password") String password) {
		super();
		this.email = email;
		this.password = password;
	}

}
