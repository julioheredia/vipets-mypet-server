package com.vipets.mypet.vipetsmypetserver.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipets.mypet.vipetsmypetserver.dao.UserRepository;
import com.vipets.mypet.vipetsmypetserver.model.User;
import com.vipets.mypet.vipetsmypetserver.service.AuthenticationService;
import com.vipets.mypet.vipetsmypetserver.util.CriptoUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	// private final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User authentication(String email, String password) {
		if (email == null)
			throw new NullPointerException();

		if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(password)) {
			password = CriptoUtil.criptografiaBase64Encoder(password);

			return userRepository.authentication(email, password);
		}
		return null;
	}
}
