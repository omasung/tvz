package com.tvz.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tvz.demo.dao.UsersDAO;
import com.tvz.demo.model.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(EntityManagerFactory entityManagerFactory) {
		sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
	}

	@Override
	public void addUsers(Users users) {
		sessionFactory.getCurrentSession().save(users);
	}

	@Override
	public void addOrUpdateUsers(Users users) {
		sessionFactory.getCurrentSession().saveOrUpdate(users);
	}

	@Override
	public void updateUsers(Users users) {
		sessionFactory.getCurrentSession().update(users);
	}

	@Override
	public Users getUsersByPk(Long usersId) {
		return (Users) sessionFactory.getCurrentSession().get(Users.class, usersId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Users> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("FROM Users").list();
	}

	@Override
	public Users getUsersByUsername(String username) {
		return (Users) sessionFactory.getCurrentSession().createQuery("FROM Users U WHERE U.username = :username")
				.setParameter("username", username).uniqueResult();
	}	
	
	@Override
	public Users getUsersByEmail(String email) {
		return (Users) sessionFactory.getCurrentSession().createQuery("FROM Users U WHERE U.email = :email")
				.setParameter("email", email).uniqueResult();
	}	
	
	@Override
	public Users getUsersByVerificationCode(String vfCode) {
		return (Users) sessionFactory.getCurrentSession().createQuery("FROM Users U WHERE U.vfCode = :vfCode")
				.setParameter("vfCode", vfCode).uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Users> getAllUsersPaginated(int pageSize, int pageNumber) {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Users ORDER BY id DESC")

				.setFirstResult(pageSize * pageNumber)//page number = pageSize * pageNumber
				.setMaxResults(pageSize)//pageSize
				
				.list();
	}
	
	@Override
	public void deleteUsers(Long usersId) {
		Users users = (Users) sessionFactory.getCurrentSession().load(Users.class, usersId);
		if (users != null) {
			this.sessionFactory.getCurrentSession().delete(users);
		}
	}
	
}
