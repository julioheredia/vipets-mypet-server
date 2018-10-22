package com.vipets.mypet.vipetsmypetserver.service;

import com.vipets.mypet.vipetsmypetserver.model.User;

public interface UserService {

	public boolean createAdmin(User admin);

	public boolean createEmployee(User employee);

	public boolean createClient(User client);

}
