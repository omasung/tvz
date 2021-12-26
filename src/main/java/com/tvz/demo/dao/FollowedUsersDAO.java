package com.tvz.demo.dao;

import java.util.List;

import com.tvz.demo.model.FollowedUsers;

public interface FollowedUsersDAO {

	void addFollowedUsers(FollowedUsers followedUsers);

	void addOrUpdateFollowedUsers(FollowedUsers followedUsers);

	void updateFollowedUsers(FollowedUsers followedUsers);

	FollowedUsers getFollowedUsersByPk(Long followedUsersId);

	List<FollowedUsers> getAllFollowedUsers();

	List<FollowedUsers> getAllFollowedUsersPaginated(int pageSize, int pageNumber);

	void deleteFollowedUsers(Long followedUsersId);

}
