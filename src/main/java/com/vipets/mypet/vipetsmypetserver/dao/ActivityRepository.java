package com.vipets.mypet.vipetsmypetserver.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vipets.mypet.vipetsmypetserver.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Long> {

	@Query("select a from Activity a where a.active = true ")
	List<Activity> activitys();

}
