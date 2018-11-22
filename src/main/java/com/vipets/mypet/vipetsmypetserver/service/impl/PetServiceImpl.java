package com.vipets.mypet.vipetsmypetserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipets.mypet.vipetsmypetserver.dao.PetRepository;
import com.vipets.mypet.vipetsmypetserver.model.Pet;
import com.vipets.mypet.vipetsmypetserver.service.PetService;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepository;

	@Override
	public List<Pet> pets() {
		return (List<Pet>) petRepository.findAll();
	}

}
