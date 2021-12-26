package com.tvz.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tvz.demo.dao.UsersDAO;
import com.tvz.demo.model.Users;
import com.tvz.demo.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired private UsersDAO usersDAO;

	@Override
	public void addUsers(Users users) {

		usersDAO.addUsers(users);
	}

	@Override
	public void addOrUpdateUsers(Users users) {

		usersDAO.addOrUpdateUsers(users);
	}

	@Override
	public void updateUsers(Users users) {

		usersDAO.updateUsers(users);
	}

	@Override
	public Users getUsersByPk(Long usersId) {

		return usersDAO.getUsersByPk(usersId);
	}

	@Override
	public Users getUsersByUsername(String username) {

		return usersDAO.getUsersByUsername(username);
	}
	
	@Override
	public Users getUsersByEmail(String email) {

		return usersDAO.getUsersByEmail(email);
	}

	@Override
	public Users getUsersByVerificationCode(String vfCode) {

		return usersDAO.getUsersByVerificationCode(vfCode);
	}
	
	@Override
	public List<Users> getAllUsers() {

		return usersDAO.getAllUsers();
	}
	
	@Override
	public List<Users> getAllUsersPaginated(int pageSize, int pageNumber) {

		return usersDAO.getAllUsersPaginated(pageSize, pageNumber);
	}

	@Override
	public void deleteUsers(Long usersId) {

		usersDAO.deleteUsers(usersId);
	}	
	
}
