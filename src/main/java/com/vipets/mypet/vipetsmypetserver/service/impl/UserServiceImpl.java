package com.vipets.mypet.vipetsmypetserver.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vipets.mypet.vipetsmypetserver.dao.PetRepository;
import com.vipets.mypet.vipetsmypetserver.dao.UserRepository;
import com.vipets.mypet.vipetsmypetserver.model.Pet;
import com.vipets.mypet.vipetsmypetserver.model.User;
import com.vipets.mypet.vipetsmypetserver.service.UserService;
import com.vipets.mypet.vipetsmypetserver.util.CriptoUtil;

@Service
public class UserServiceImpl implements UserService {

	private String passwordEmpty = "vipets";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PetRepository petRepository;

	@Override
	public List<User> clientsByPetshop(Long petshopId) {
		return userRepository.clientsByPetshop(petshopId);
	}

	@Override
	public List<User> employeesByPetshop(Long petshopId) {
		return userRepository.employeesByPetshop(petshopId);
	}

	@Transactional
	@Override
	public User saveAdmin(User admin) {
		admin = setAuthUser(admin, true, false, false, false);
		admin = critpoPassword(admin);
		return userRepository.save(admin);
	}

	@Transactional
	@Override
	public User saveEmployee(User employee) {
		employee = setAuthUser(employee, false, true, false, false);
		employee = critpoPassword(employee);
		return userRepository.save(employee);
	}

	@Transactional
	@Override
	public User saveClient(User client) {
		client = setAuthUser(client, false, false, true, true);
		client = critpoPassword(client);
		return userRepository.save(client);
	}

	private User setAuthUser(User user, boolean isAdmin, boolean isEmployee, boolean isClient, boolean createPet) {
		if (createPet)
			savePetsBeforer(user);

		if (StringUtils.isBlank(user.getPassword()))
			user.setPassword(passwordEmpty);

		user.setLastChangeDate(LocalDateTime.now());
		user.setRegistrationDate(LocalDateTime.now());

		user.setAdmin(isAdmin);
		user.setEmployee(isEmployee);
		user.setClient(isClient);
		return user;
	}

	private void savePetsBeforer(User user) {
		List<Pet> pets = user.getPets() == null ? new ArrayList<Pet>() : user.getPets();
		for (Pet pet : pets) {
			petRepository.save(pet);
		}
	}

	private User critpoPassword(User user) {
		String password = CriptoUtil.criptografiaBase64Encoder(user.getPassword());
		user.setPassword(password);
		return user;
	}

}
