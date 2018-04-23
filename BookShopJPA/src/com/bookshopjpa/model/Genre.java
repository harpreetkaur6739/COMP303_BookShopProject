package com.bookshopjpa.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Genre
 *
 */
@Entity

public class Genre implements Serializable
{
	private Integer genreId;
	private String name;
	private Set<Book> books;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "BookGenres",
		joinColumns = { @JoinColumn(name = "genreId") },
		inverseJoinColumns = { @JoinColumn(name = "bookId") })
	public Set<Book> getBooks()
	{
		return this.books;
	}

	public Genre()
	{
		super();
	}
	
	@Id
	public Integer getGenreId()
	{
		return this.genreId;
	}

	public void setGenreId(Integer genreId)
	{
		this.genreId = genreId;
	}
	
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
