package com.vipets.mypet.vipetsmypetserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipets.mypet.vipetsmypetserver.dao.BreedRepository;
import com.vipets.mypet.vipetsmypetserver.model.Breed;
import com.vipets.mypet.vipetsmypetserver.service.BreedService;

@Service
public class BreedServiceImpl implements BreedService {

	@Autowired
	private BreedRepository breedRepository;

	@Override
	public List<Breed> breeds() {
		return (List<Breed>) breedRepository.findAll();
	}

}
