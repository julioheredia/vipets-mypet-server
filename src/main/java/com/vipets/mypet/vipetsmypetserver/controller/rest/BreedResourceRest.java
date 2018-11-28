package com.vipets.mypet.vipetsmypetserver.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vipets.mypet.vipetsmypetserver.model.Breed;
import com.vipets.mypet.vipetsmypetserver.service.BreedService;

@RestController
public class BreedResourceRest {

	@Autowired
	private BreedService breedService;

	@RequestMapping("/breeds")
	public List<Breed> breeds() {
		return breedService.breeds();
	}
	
}
