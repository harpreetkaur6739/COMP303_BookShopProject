package com.bookshopweb.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.bookshopweb.model.Author;
import com.sun.mail.iap.ConnectionException;

public class AuthorDAO
{
	public static List<Author> list()
	{
		EntityManager em = Connection.getEntityManager();
		
		Query q = em.createNamedQuery("Author.All");
		List<Author> list = q.getResultList();
		
		return list;
	}
	
	public static Author read(int authorId)
	{
		EntityManager em = Connection.getEntityManager();
		Author author = em.find(Author.class, authorId);
		return author;
	}
	
	public static Author updateOrCreate(Author author)
	{
		EntityManager em = Connection.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(author);
		et.commit();
		
		return author;
	}
	
	public static void delete(Author author)
	{
		EntityManager em = Connection.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.remove(author);
		et.commit();
	}
}
