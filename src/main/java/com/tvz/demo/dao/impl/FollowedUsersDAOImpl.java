package com.tvz.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tvz.demo.dao.FollowedUsersDAO;
import com.tvz.demo.model.FollowedUsers;

@Repository
public class FollowedUsersDAOImpl implements FollowedUsersDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(EntityManagerFactory entityManagerFactory) {
		sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
	}

	@Override
	public void addFollowedUsers(FollowedUsers followedUsers) {
		sessionFactory.getCurrentSession().save(followedUsers);
	}

	@Override
	public void addOrUpdateFollowedUsers(FollowedUsers followedUsers) {
		sessionFactory.getCurrentSession().saveOrUpdate(followedUsers);
	}

	@Override
	public void updateFollowedUsers(FollowedUsers followedUsers) {
		sessionFactory.getCurrentSession().update(followedUsers);
	}

	@Override
	public FollowedUsers getFollowedUsersByPk(Long followedUsersId) {
		return (FollowedUsers) sessionFactory.getCurrentSession().get(FollowedUsers.class, followedUsersId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<FollowedUsers> getAllFollowedUsers() {
		return sessionFactory.getCurrentSession().createQuery("FROM FollowedUsers").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<FollowedUsers> getAllFollowedUsersPaginated(int pageSize, int pageNumber) {
		
		return sessionFactory.getCurrentSession().createQuery("FROM FollowedUsers ORDER BY id DESC")

				.setFirstResult(pageSize * pageNumber)//page number = pageSize * pageNumber
				.setMaxResults(pageSize)//pageSize
				
				.list();
	}
	
	@Override
	public void deleteFollowedUsers(Long followedUsersId) {
		FollowedUsers followedUsers = (FollowedUsers) sessionFactory.getCurrentSession().load(FollowedUsers.class, followedUsersId);
		if (followedUsers != null) {
			this.sessionFactory.getCurrentSession().delete(followedUsers);
		}
	}	
	
}
