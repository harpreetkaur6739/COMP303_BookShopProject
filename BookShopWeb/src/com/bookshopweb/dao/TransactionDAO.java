package com.bookshopweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bookshopweb.model.Book;
import com.bookshopweb.model.Transaction;

public class TransactionDAO
{
	private Database db;
	
	public TransactionDAO(Database db)
	{
		this.db = db;
	}
	public Transaction updateOrCreate(Transaction txn)
	{
		EntityManager em = this.db.getEntityManager();
	
		em.persist(txn);
		
		em.flush();
		
		return txn;
	}
	
	public List<Transaction> findByUser(String user){
		EntityManager em = this.db.getEntityManager();
		
		Query q = em.createNamedQuery("Transaction.findByUser");
		q.setParameter("user", user);
		List<Transaction> list = q.getResultList();
		
		return list;
		
	}
	public List<Transaction> findAll(){
		EntityManager em = this.db.getEntityManager();
		
		Query q = em.createNamedQuery("Transaction.findAll");
		
		List<Transaction> list = q.getResultList();
		
		return list;
		
	}
	
}
