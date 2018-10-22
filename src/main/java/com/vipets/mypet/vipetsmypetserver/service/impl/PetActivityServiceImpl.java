package com.vipets.mypet.vipetsmypetserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipets.mypet.vipetsmypetserver.dao.PetActivityRepository;
import com.vipets.mypet.vipetsmypetserver.model.PetActivity;
import com.vipets.mypet.vipetsmypetserver.model.Petshop;
import com.vipets.mypet.vipetsmypetserver.service.PetActivityService;

@Service
public class PetActivityServiceImpl implements PetActivityService {

	@Autowired
	private PetActivityRepository petActivityRepository;

	@Override
	public List<PetActivity> searchPetActivityByPetshop(Petshop petshop) {
		return petActivityRepository.searchPetActivityByPetshop(petshop);
	}

}
