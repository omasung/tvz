package com.tvz.demo.service;

import java.util.List;

import com.tvz.demo.model.FollowedUsers;

public interface FollowedUsersService {

	void addFollowedUsers(FollowedUsers followedUsers);

	void addOrUpdateFollowedUsers(FollowedUsers followedUsers);

	void updateFollowedUsers(FollowedUsers followedUsers);

	FollowedUsers getFollowedUsersByPk(Long followedUsersId);

	List<FollowedUsers> getAllFollowedUsers();

	List<FollowedUsers> getAllFollowedUsersPaginated(int pageSize, int pageNumber);

	void deleteFollowedUsers(Long followedUsersId);
	
}
