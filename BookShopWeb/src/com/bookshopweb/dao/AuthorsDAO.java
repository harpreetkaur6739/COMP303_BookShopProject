package com.bookshopweb.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.bookshopweb.model.Author;
import com.sun.mail.iap.ConnectionException;

public class AuthorsDAO
{
	private Database db;
	
	public AuthorsDAO(Database db)
	{
		this.db = db;
	}
	
	public List<Author> list()
	{
		EntityManager em = this.db.getEntityManager();
		
		Query q = em.createNamedQuery("Author.All");
		List<Author> list = q.getResultList();
		
		return list;
	}
	
	public Author read(int authorId)
	{
		EntityManager em = this.db.getEntityManager();
		Author author = em.find(Author.class, authorId);
		return author;
	}
	
	public Author updateOrCreate(Author author)
	{
		EntityManager em = this.db.getEntityManager();
		em.persist(author);
		em.flush();
		
		return author;
	}
	
	public void delete(Author author)
	{
		EntityManager em = this.db.getEntityManager();
		em.remove(author);
	}
}
