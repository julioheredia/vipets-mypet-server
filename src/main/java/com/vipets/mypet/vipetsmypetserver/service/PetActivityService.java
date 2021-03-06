package com.vipets.mypet.vipetsmypetserver.service;

import java.util.List;

import com.vipets.mypet.vipetsmypetserver.model.PetActivity;

public interface PetActivityService {

	public List<PetActivity> petActivitysByPetshop(Long petshopId);

	public List<PetActivity> petActivitysByEmployee(Long userId);

	public PetActivity savePetActivitys(PetActivity petActivity);

}
