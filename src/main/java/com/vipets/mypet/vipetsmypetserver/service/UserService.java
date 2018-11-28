package com.vipets.mypet.vipetsmypetserver.service;

import java.util.List;

import com.vipets.mypet.vipetsmypetserver.model.User;

public interface UserService {

	public User createAdmin(User admin);

	public User createEmployee(User employee);

	public User createClient(User client);

	public List<User> employeesByPetshop(Long petshopId);

	public List<User> clientsByPetshop(Long petshopId);

}
