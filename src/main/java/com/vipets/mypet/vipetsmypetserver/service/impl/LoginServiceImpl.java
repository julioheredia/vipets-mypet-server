package com.vipets.mypet.vipetsmypetserver.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipets.mypet.vipetsmypetserver.dao.UserRepository;
import com.vipets.mypet.vipetsmypetserver.model.User;
import com.vipets.mypet.vipetsmypetserver.service.LoginService;
import com.vipets.mypet.vipetsmypetserver.util.CriptoUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LoginServiceImpl implements LoginService {

	private final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(String email, String password) {

		logger.debug("metodo de login - " + email + " - parametro ");
		if (email == null)
			throw new NullPointerException();

		if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(password)) {
			password = CriptoUtil.criptografiaBase64Encoder(password);

			User loger = userRepository.login(email, password);

			logger.debug("logou  " + loger.getEmail());

			return loger;
		}
		return null;
	}
}
