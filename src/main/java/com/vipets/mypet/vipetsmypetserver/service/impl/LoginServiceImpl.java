package com.vipets.mypet.vipetsmypetserver.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipets.mypet.vipetsmypetserver.dao.UserRepository;
import com.vipets.mypet.vipetsmypetserver.model.User;
import com.vipets.mypet.vipetsmypetserver.service.LoginService;
import com.vipets.mypet.vipetsmypetserver.util.CriptoUtil;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(String email, String password) {
		if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(password)) {
			password = CriptoUtil.criptografiaBase64Encoder(password);			
			return userRepository.login(email, password);
		}
		return null;
	}
}
