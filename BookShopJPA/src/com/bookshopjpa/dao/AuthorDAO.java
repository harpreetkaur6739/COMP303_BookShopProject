package com.bookshopjpa.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.bookshopjpa.model.Author;

public class AuthorDAO
{
	public static List<Author> getAuthors()
	{
		EntityManager em = Connection.getEntityManager();
		
		Query q = em.createNamedQuery("Author.All");
		List<Author> list = q.getResultList();
		
		return list;
	}
}
