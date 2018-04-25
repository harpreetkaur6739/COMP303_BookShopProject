package com.bookshopweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Database implements AutoCloseable
{
	private EntityManager em;
	private EntityTransaction et;
	private AuthorDAO authors;
	private GenresDAO genres;
	
	public Database()
	{
		this.em = Connection.getEntityManager();
		this.et = this.em.getTransaction();
		this.authors = new AuthorDAO(this);
		this.genres = new GenresDAO(this);
		
		this.et.begin();
	}
	
	public AuthorDAO getAuthors()
	{
		return this.authors;
	}
	
	public GenresDAO getGenres()
	{
		return this.genres;
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
	}
}
