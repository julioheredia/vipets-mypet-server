package com.vipets.mypet.vipetsmypetserver.service;

import java.util.List;

import com.vipets.mypet.vipetsmypetserver.model.User;

public interface UserService {

	public User saveAdmin(User admin);

	public User saveEmployee(User employee);

	public User saveClient(User client);

	public List<User> employeesByPetshop(Long petshopId);

	public List<User> clientsByPetshop(Long petshopId);

}
