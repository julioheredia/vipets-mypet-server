package com.vipets.mypet.vipetsmypetserver.service;

import java.util.List;

import com.vipets.mypet.vipetsmypetserver.model.PetActivity;
import com.vipets.mypet.vipetsmypetserver.model.Petshop;

public interface PetActivityService {

	public List<PetActivity> searchPetActivityByPetshop(Petshop petshop);
	
}
