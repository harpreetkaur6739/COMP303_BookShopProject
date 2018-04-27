package com.bookshopweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Database implements AutoCloseable
{
	private EntityManager em;
	private EntityTransaction et;
	private AuthorsDAO authors;
	private GenresDAO genres;
	private BooksDAO books;
	private HistoryDAO history;

	private UserDAO users;
	private TransactionDAO transactions;

	
	public Database()
	{
		this.em = Connection.getEntityManager();
		this.et = this.em.getTransaction();
		this.authors = new AuthorsDAO(this);
		this.genres = new GenresDAO(this);
		this.books = new BooksDAO(this);

		this.history = new HistoryDAO(this);

		this.users = new UserDAO(this);
		this.transactions = new TransactionDAO(this);

		
		this.et.begin();
	}
	
	public TransactionDAO getTransactions() {
		return transactions;
	}

	public void setTransactions(TransactionDAO transactions) {
		this.transactions = transactions;
	}

	public AuthorsDAO getAuthors()
	{
		return this.authors;
	}
	
	public GenresDAO getGenres()
	{
		return this.genres;
	}
	
	public BooksDAO getBooks()
	{
		return this.books;
	}

	public HistoryDAO getHistory()
	{
		return this.history;
	}
	

	public UserDAO getUsers() {
		return users;
	}

	public void setUsers(UserDAO users) {
		this.users = users;
	}


	public EntityManager getEntityManager()
	{
		return this.em;
	}
	
	public EntityTransaction getTransaction()
	{
		return this.et;
	}
	
	public void commit()
	{
		this.et.commit();
	}

	@Override
	public void close() throws Exception
	{
		if (this.et.isActive())
		{
			this.et.rollback();
		}
		
		this.em.close();
	}
}
