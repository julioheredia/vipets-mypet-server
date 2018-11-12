package com.vipets.mypet.vipetsmypetserver.service;

import com.vipets.mypet.vipetsmypetserver.model.User;

public interface AuthenticationService {

	public User authentication(String email, String password);

}
