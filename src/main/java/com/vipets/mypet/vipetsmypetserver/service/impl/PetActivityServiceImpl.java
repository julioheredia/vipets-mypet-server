package com.vipets.mypet.vipetsmypetserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipets.mypet.vipetsmypetserver.dao.PetActivityRepository;
import com.vipets.mypet.vipetsmypetserver.model.PetActivity;
import com.vipets.mypet.vipetsmypetserver.model.Petshop;
import com.vipets.mypet.vipetsmypetserver.model.User;
import com.vipets.mypet.vipetsmypetserver.service.PetActivityService;

@Service
public class PetActivityServiceImpl implements PetActivityService {

	@Autowired
	private PetActivityRepository petActivityRepository;

	@Override
	public List<PetActivity> searchPetActivityByPetshop(Petshop petshop) {
		return petActivityRepository.searchPetActivityByPetshop(petshop);
	}

	@Override
	public List<PetActivity> searchPetActivityByUser(User user) {

		System.out.println("petActivityRepository user_id" + user.getUserId());
		
		List<PetActivity> atcis = petActivityRepository.searchPetActivityByUser(user);
		for (PetActivity petActivity : atcis) {
			System.out.println(petActivity.getActivity().getDescription());
		}

		return atcis;
	}

}
