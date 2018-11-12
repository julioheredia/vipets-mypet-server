package com.vipets.mypet.vipetsmypetserver.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipets.mypet.vipetsmypetserver.dao.PetActivityRepository;
import com.vipets.mypet.vipetsmypetserver.model.PetActivity;
import com.vipets.mypet.vipetsmypetserver.service.PetActivityService;

@Service
public class PetActivityServiceImpl implements PetActivityService {

	@Autowired
	private PetActivityRepository petActivityRepository;

	@Override
	public List<PetActivity> petActivitysByPetshop(Long petshopId) {
		return petActivityRepository.petActivitysByPetshop(petshopId, LocalDateTime.now());
	}

	@Override
	public List<PetActivity> petActivitysByUser(Long userId) {
		return petActivityRepository.petActivitysByUser(userId, LocalDateTime.now());
	}

}
