package com.vipets.mypet.vipetsmypetserver.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vipets.mypet.vipetsmypetserver.model.Activity;
import com.vipets.mypet.vipetsmypetserver.service.ActivityService;

@RestController
public class ActivityResourceRest {

	@Autowired
	private ActivityService activityService;

	@RequestMapping("/activitys")
	public List<Activity> activitys(){
		return activityService.activitys();
	}
}
