package com.vipets.mypet.vipetsmypetserver.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vipets.mypet.vipetsmypetserver.model.Pet;
import com.vipets.mypet.vipetsmypetserver.service.PetService;

@RestController
public class PetResourceRest {

	@Autowired
	private PetService petService;

	@RequestMapping("/pets")
	public List<Pet> pets() {
		return petService.pets();
	}

}
