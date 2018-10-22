package com.vipets.mypet.vipetsmypetserver.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vipets.mypet.vipetsmypetserver.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("select u from User u where u.email =:email and u.password =:password ")
	User login(@Param("email") String email, @Param("password") String password);

}