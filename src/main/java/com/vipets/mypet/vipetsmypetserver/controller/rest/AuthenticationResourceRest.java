package com.vipets.mypet.vipetsmypetserver.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vipets.mypet.vipetsmypetserver.model.User;
import com.vipets.mypet.vipetsmypetserver.security.Credentials;
import com.vipets.mypet.vipetsmypetserver.service.AuthenticationService;

@RestController
public class AuthenticationResourceRest {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/authentication")
	public User authentication(@RequestBody Credentials credentials) {
		return authenticationService.authentication(credentials.getEmail(), credentials.getPassword());
	}

}
