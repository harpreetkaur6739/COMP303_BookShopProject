package com.bookshopweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bookshopweb.model.Book;

public class BookDaoImpl implements BookDAO{

	public List<Book> listAllBooks(){
		List<Book> list = null;
		try {
			EntityManager em = Connection.getEntityManager();
			
			Query q = em.createNamedQuery("Books.All");
			list = q.getResultList();			
			
		}catch(Exception ex) {
			System.out.println("Error fetching list of all books.");
		}
		
		return list;
	}
}
