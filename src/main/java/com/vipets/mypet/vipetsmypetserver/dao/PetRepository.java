package com.vipets.mypet.vipetsmypetserver.dao;

import org.springframework.data.repository.CrudRepository;

import com.vipets.mypet.vipetsmypetserver.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
