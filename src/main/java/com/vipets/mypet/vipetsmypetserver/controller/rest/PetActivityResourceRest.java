package com.vipets.mypet.vipetsmypetserver.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vipets.mypet.vipetsmypetserver.model.PetActivity;
import com.vipets.mypet.vipetsmypetserver.model.User;
import com.vipets.mypet.vipetsmypetserver.service.PetActivityService;

@RestController
public class PetActivityResourceRest {

	@Autowired
	private PetActivityService petActivityService;

	@PostMapping("/searchPetActivityByUser")
	public List<PetActivity> searchPetActivityByUser(@RequestParam(value = "user", defaultValue = "user") User user) {
		return petActivityService.searchPetActivityByUser(user);
	}

}
