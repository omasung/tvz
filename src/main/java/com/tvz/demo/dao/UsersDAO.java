package com.tvz.demo.dao;

import java.util.List;

import com.tvz.demo.model.Users;

public interface UsersDAO {

	void addUsers(Users users);

	void addOrUpdateUsers(Users users);

	void updateUsers(Users users);

	Users getUsersByPk(Long usersId);
	
	Users getUsersByUsername(String username);
	
	Users getUsersByEmail(String email);
	
	Users getUsersByVerificationCode(String vfCode);

	List<Users> getAllUsers();

	List<Users> getAllUsersPaginated(int pageSize, int pageNumber);

	void deleteUsers(Long usersId);

}
