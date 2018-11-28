package com.vipets.mypet.vipetsmypetserver.service;

import java.util.List;

import com.vipets.mypet.vipetsmypetserver.model.Pet;

public interface PetService {

	public List<Pet> petsByPetshop(Long petshopId);

	public Pet createPet(Pet pet);

}
