package com.vipets.mypet.vipetsmypetserver.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vipets.mypet.vipetsmypetserver.model.User;
import com.vipets.mypet.vipetsmypetserver.security.Credentials;
import com.vipets.mypet.vipetsmypetserver.service.LoginService;

@RestController
public class LoginResourceRest {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public User login(@RequestBody Credentials credentials) {
		return loginService.login(credentials.getEmail(), credentials.getPassword());
	}
}
