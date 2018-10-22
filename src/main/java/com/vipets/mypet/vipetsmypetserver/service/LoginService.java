package com.vipets.mypet.vipetsmypetserver.service;

import com.vipets.mypet.vipetsmypetserver.model.User;

public interface LoginService {

	public User login(String email, String password);

}
