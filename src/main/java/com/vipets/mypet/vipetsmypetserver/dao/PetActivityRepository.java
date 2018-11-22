package com.vipets.mypet.vipetsmypetserver.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vipets.mypet.vipetsmypetserver.model.PetActivity;

public interface PetActivityRepository extends CrudRepository<PetActivity, Long> {

	@Query("select p from PetActivity p where p.petshop.petshopId = :petshopId  and p.activityEnd >= :time order by p.clientScheduledTime ")
	List<PetActivity> petActivitysByPetshop(@Param("petshopId") Long petshopId, @Param("time") LocalDateTime time);

	@Query("select p from PetActivity p where p.user.userId = :userId and p.activityEnd >= :time order by p.clientScheduledTime ")
	List<PetActivity> petActivitysByUser(@Param("userId") Long userId, @Param("time") LocalDateTime time);
	
}
