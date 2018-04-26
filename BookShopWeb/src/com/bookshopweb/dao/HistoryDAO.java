package com.bookshopweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.bookshopweb.model.History;

public class HistoryDAO
{
	private Database db;
	
	public HistoryDAO(Database db)
	{
		this.db = db;
	}
	
	public List<History> list()
	{
		EntityManager em = this.db.getEntityManager();
		
		Query q = em.createNamedQuery("History.Recent").setMaxResults(100);
		List<History> list = q.getResultList();
		
		return list;
	}
	
	public void create(History history)
	{
		EntityManager em = this.db.getEntityManager();
		em.persist(history);
		em.flush();
	}
}
