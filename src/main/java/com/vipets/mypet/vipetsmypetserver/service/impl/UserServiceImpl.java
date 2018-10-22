package com.vipets.mypet.vipetsmypetserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipets.mypet.vipetsmypetserver.dao.UserRepository;
import com.vipets.mypet.vipetsmypetserver.model.User;
import com.vipets.mypet.vipetsmypetserver.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean createAdmin(User admin) {
		admin = setAuthUser(admin, true, false, false);
		User saveUser = userRepository.save(admin);
		if (saveUser != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean createEmployee(User employee) {
		employee = setAuthUser(employee, false, true, false);
		User saveUser = userRepository.save(employee);
		if (saveUser != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean createClient(User client) {
		client = setAuthUser(client, false, false, true);
		User saveUser = userRepository.save(client);
		if (saveUser != null)
			return true;
		else
			return false;
	}

	private User setAuthUser(User user, boolean isAdmin, boolean isEmployee, boolean isClient) {
		user.setAdmin(isAdmin);
		user.setEmployee(isEmployee);
		user.setClient(isClient);
		return user;
	}

}