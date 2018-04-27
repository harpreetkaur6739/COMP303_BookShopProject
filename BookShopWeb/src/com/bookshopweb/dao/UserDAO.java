package com.bookshopweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bookshopweb.model.User;

public class UserDAO {
	
	private Database db;
	
	public UserDAO(Database db)
	{
		this.db = db;
	}
	
	public User authenticate(String username, String password) {
		
		EntityManager em = this.db.getEntityManager();
		
		Query q = em.createNamedQuery("User.find");
		q.setParameter("user", username);
		q.setParameter("pwd", password);
		User userResult = null;
		if(q.getResultList()!=null) {
			userResult = new User();
			userResult = (User)q.getResultList().get(0);
		}
		
	
		return userResult;
	}
	
	public User create(User user) {
		EntityManager em = this.db.getEntityManager();
		em.persist(user);
		em.flush();
		em.getTransaction().commit();
		
		return user;
	}
}
