package com.vipets.mypet.vipetsmypetserver.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vipets.mypet.vipetsmypetserver.model.PetActivity;
import com.vipets.mypet.vipetsmypetserver.model.Petshop;
import com.vipets.mypet.vipetsmypetserver.service.PetActivityService;

@RestController
public class PetActivityResourceRest {

	@Autowired
	private PetActivityService petActivityService;

	@RequestMapping("/searchPetActivityByPetshop")
	public List<PetActivity> searchPetActivityByPetshop(
			@RequestParam(value = "petshop", defaultValue = "petshop") Petshop petshop) {
		return petActivityService.searchPetActivityByPetshop(petshop);
	}

}
