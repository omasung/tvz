package com.tvz.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tvz.demo.dao.FollowedUsersDAO;
import com.tvz.demo.model.FollowedUsers;
import com.tvz.demo.service.FollowedUsersService;

@Service
@Transactional
public class FollowedUsersServiceImpl implements FollowedUsersService {

	@Autowired private FollowedUsersDAO followedUsersDAO;

	@Override
	public void addFollowedUsers(FollowedUsers followedUsers) {

		followedUsersDAO.addFollowedUsers(followedUsers);
	}

	@Override
	public void addOrUpdateFollowedUsers(FollowedUsers followedUsers) {

		followedUsersDAO.addOrUpdateFollowedUsers(followedUsers);
	}

	@Override
	public void updateFollowedUsers(FollowedUsers followedUsers) {

		followedUsersDAO.updateFollowedUsers(followedUsers);
	}

	@Override
	public FollowedUsers getFollowedUsersByPk(Long followedUsersId) {

		return followedUsersDAO.getFollowedUsersByPk(followedUsersId);
	}

	@Override
	public List<FollowedUsers> getAllFollowedUsers() {

		return followedUsersDAO.getAllFollowedUsers();
	}
	
	@Override
	public List<FollowedUsers> getAllFollowedUsersPaginated(int pageSize, int pageNumber) {

		return followedUsersDAO.getAllFollowedUsersPaginated(pageSize, pageNumber);
	}

	@Override
	public void deleteFollowedUsers(Long followedUsersId) {

		followedUsersDAO.deleteFollowedUsers(followedUsersId);
	}	
	
}
