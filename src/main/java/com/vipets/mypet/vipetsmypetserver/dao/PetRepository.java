package com.vipets.mypet.vipetsmypetserver.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vipets.mypet.vipetsmypetserver.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

	@Query("select p from Pet p join p.owners o join o.petshops ps where ps.petshopId = :petshopId ")
	public List<Pet> petsByPetshop(@Param("petshopId") Long petshopId);
	
}
