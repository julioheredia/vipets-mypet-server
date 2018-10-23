package com.vipets.mypet.vipetsmypetserver.service;

import java.util.List;

import com.vipets.mypet.vipetsmypetserver.model.PetActivity;
import com.vipets.mypet.vipetsmypetserver.model.Petshop;
import com.vipets.mypet.vipetsmypetserver.model.User;

public interface PetActivityService {

	public List<PetActivity> searchPetActivityByPetshop(Petshop petshop);

	public List<PetActivity> searchPetActivityByUser(User user);
}
