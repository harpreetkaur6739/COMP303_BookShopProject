package com.bookshopweb.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.bookshopweb.model.Genre;
import com.sun.mail.iap.ConnectionException;

public class GenresDAO
{
	private Database db;
	
	public GenresDAO(Database db)
	{
		this.db = db;
	}
	
	public List<Genre> list()
	{
		EntityManager em = this.db.getEntityManager();
		
		Query q = em.createNamedQuery("Genre.All");
		List<Genre> list = q.getResultList();
		
		return list;
	}
	
	public Genre read(int genreId)
	{
		EntityManager em = this.db.getEntityManager();
		Genre genre = em.find(Genre.class, genreId);
		return genre;
	}
	
	public Genre updateOrCreate(Genre genre)
	{
		EntityManager em = this.db.getEntityManager();
		em.persist(genre);
		em.flush();
		
		return genre;
	}
	
	public void delete(Genre genre)
	{
		EntityManager em = this.db.getEntityManager();
		em.remove(genre);
	}
}
