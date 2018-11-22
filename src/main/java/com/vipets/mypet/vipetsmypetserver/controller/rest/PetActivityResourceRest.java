package com.vipets.mypet.vipetsmypetserver.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vipets.mypet.vipetsmypetserver.model.PetActivity;
import com.vipets.mypet.vipetsmypetserver.service.PetActivityService;

@RestController
public class PetActivityResourceRest {

	@Autowired
	private PetActivityService petActivityService;

	@RequestMapping("/petActivitys/user")
	public List<PetActivity> petActivitysByUser(@RequestParam(value = "userId") Long userId) {
		return petActivityService.petActivitysByUser(userId);
	}

	@RequestMapping("/petActivitys/petshop")
	public List<PetActivity> petActivitysByPetshop(@RequestParam(value = "petshopId") Long petshopId) {
		return petActivityService.petActivitysByPetshop(petshopId);
	}

	@PutMapping("/petActivitys")
	public PetActivity createPetActivitys(@RequestBody PetActivity petActivity) {
		return petActivityService.createPetActivitys(petActivity);
	}

}
