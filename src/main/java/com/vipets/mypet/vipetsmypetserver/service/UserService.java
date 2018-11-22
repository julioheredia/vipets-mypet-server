package com.vipets.mypet.vipetsmypetserver.service;

import java.util.List;

import com.vipets.mypet.vipetsmypetserver.model.User;

public interface UserService {

	public boolean createAdmin(User admin);

	public boolean createEmployee(User employee);

	public boolean createClient(User client);

	public List<User> employees();

}
