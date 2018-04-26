package com.bookshopweb.dao;

import javax.persistence.EntityManager;

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
	
}
