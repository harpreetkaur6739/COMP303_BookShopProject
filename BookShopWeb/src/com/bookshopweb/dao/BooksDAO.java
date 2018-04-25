package com.bookshopweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bookshopweb.model.Author;
import com.bookshopweb.model.Book;

public class BooksDAO
{
	private Database db;
	
	public BooksDAO(Database db)
	{
		this.db = db;
	}
	
	public List<Book> list()
	{
		EntityManager em = this.db.getEntityManager();
		
		Query q = em.createNamedQuery("Book.All");
		List<Book> list = q.getResultList();
		
		return list;
	}
	
	public Book read(int bookId)
	{
		EntityManager em = this.db.getEntityManager();
		Book book = em.find(Book.class, bookId);
		return book;
	}
	
	public Book updateOrCreate(Book book)
	{
		EntityManager em = this.db.getEntityManager();
		em.persist(book);
		em.flush();
		
		return book;
	}
	
	public void delete(Book book)
	{
		EntityManager em = this.db.getEntityManager();
		em.remove(book);
	}
}
