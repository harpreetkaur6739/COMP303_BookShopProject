package com.bookshopweb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bookshopweb.model.Author;
import com.bookshopweb.model.Book;
import com.bookshopweb.model.BookWithAuthor;
import com.bookshopweb.model.BookWithGenre;
import com.bookshopweb.model.Genre;

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
	
	public List<Book> search(String query)
	{
		EntityManager em = this.db.getEntityManager();
		
		Query q = em.createNamedQuery("Book.Search");
		q.setParameter("query", "%" + query + "%");
		List<Book> list = q.getResultList();
		
		return list;
	}
	
	public List<BookWithAuthor> searchAuthors(int bookId, String query)
	{
		String pattern = "%";
		if (query != null && query.length() > 0)
		{
			pattern = "%" + query + "%";
		}
		
		EntityManager em = this.db.getEntityManager();
		
		Query q = em.createNamedQuery("Book.SearchAuthor");
		q.setParameter("bookId", bookId);
		q.setParameter("query", pattern);
		List<Object[]> results = q.getResultList();
		List<BookWithAuthor> list = new ArrayList<BookWithAuthor>();
		
		for (Object[] values : results)
		{
			Author author = (Author)values[0];
			Book book = (Book)values[1];
			list.add(new BookWithAuthor(book, author));
		}
		
		return list;
	}
	
	public List<BookWithGenre> searchGenres(int bookId, String query)
	{
		String pattern = "%";
		if (query != null && query.length() > 0)
		{
			pattern = "%" + query + "%";
		}
		
		EntityManager em = this.db.getEntityManager();
		
		Query q = em.createNamedQuery("Book.SearchGenre");
		q.setParameter("bookId", bookId);
		q.setParameter("query", pattern);
		List<Object[]> results = q.getResultList();
		List<BookWithGenre> list = new ArrayList<BookWithGenre>();
		
		for (Object[] values : results)
		{
			Genre genre = (Genre)values[0];
			Book book = (Book)values[1];
			list.add(new BookWithGenre(book, genre));
		}
		
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
		em.persist(book.getDetail());
		em.persist(book.getInventory());
		em.persist(book);
		
		em.flush();
		
		return book;
	}
	
	public void delete(Book book)
	{
		EntityManager em = this.db.getEntityManager();
		em.remove(book);
	}
	
	public List<Book> searchAvailableBooks(){
		List<Book> books = null;
		EntityManager em = this.db.getEntityManager();
		
		Query q = em.createNamedQuery("Book.SearchAvailable");
		books = q.getResultList();
		return books;
	}
	
	public void updateInventory(int bookId, int qty) {
		
		EntityManager em = this.db.getEntityManager();
		
		Book book = em.find(Book.class, bookId);
		
		int quantity = book.getInventory().getQuantity() - qty;
		book.getInventory().setQuantity(quantity);
		
		em.persist(book.getInventory());		
		em.flush();
		
	}
}
