package com.vipets.mypet.vipetsmypetserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipets.mypet.vipetsmypetserver.dao.ActivityRepository;
import com.vipets.mypet.vipetsmypetserver.model.Activity;
import com.vipets.mypet.vipetsmypetserver.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public List<Activity> activitys(){
		return activityRepository.activitys();
	}

}
