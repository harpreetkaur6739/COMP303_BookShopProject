package com.bookshopweb.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Connection
{
	private static EntityManagerFactory emf = null;
		
	static
	{
		InitialContext ctx;
		try
		{
			ctx = new InitialContext();
			emf = (EntityManagerFactory)ctx.lookup("java:/comp303project_emf");
		}
		catch (NamingException e)
		{
			e.printStackTrace();
		}
	}
	
	public static synchronized EntityManager getEntityManager()
	{
		return emf.createEntityManager();
	}
	
	public static EntityTransaction beginTransaction()
	{
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		return et;
	}
}
