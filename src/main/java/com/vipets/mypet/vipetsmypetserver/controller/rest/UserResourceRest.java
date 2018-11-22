package com.vipets.mypet.vipetsmypetserver.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vipets.mypet.vipetsmypetserver.model.User;
import com.vipets.mypet.vipetsmypetserver.service.UserService;

@RestController
public class UserResourceRest {

	@Autowired
	private UserService userService;

	@RequestMapping("/users/employees")
	public List<User> employees() {
		return userService.employees();
	}

}
