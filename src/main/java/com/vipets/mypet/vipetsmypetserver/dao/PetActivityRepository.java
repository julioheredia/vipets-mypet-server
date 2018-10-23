package com.vipets.mypet.vipetsmypetserver.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vipets.mypet.vipetsmypetserver.model.PetActivity;
import com.vipets.mypet.vipetsmypetserver.model.Petshop;
import com.vipets.mypet.vipetsmypetserver.model.User;

public interface PetActivityRepository extends CrudRepository<PetActivity, Long> {

	@Query("select p from PetActivity p where p.petshop = :petshop ")
	List<PetActivity> searchPetActivityByPetshop(@Param("petshop") Petshop petshop);

	@Query("select p from PetActivity p where p.user = :user ")
	List<PetActivity> searchPetActivityByUser(@Param("user") User user);

}
