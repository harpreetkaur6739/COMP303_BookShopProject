package com.bookshopjpa.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Book
 *
 */
@Entity

public class Book implements Serializable
{
	private Integer bookId;
	private String title;
	private Date publishDate;
	private String isbn;
	private Integer rating;
	private Set<Author> authors;
	private Set<Genre> genres;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "BookAuthors",
		joinColumns = { @JoinColumn(name = "bookId") },
		inverseJoinColumns = { @JoinColumn(name = "authorId") })
	public Set<Author> getAuthors()
	{
		return this.authors;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "BookGenres",
		joinColumns = { @JoinColumn(name = "bookId") },
		inverseJoinColumns = { @JoinColumn(name = "genreId") })
	public Set<Genre> getGenres()
	{
		return this.genres;
	}

	public Book()
	{
		super();
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBookId()
	{
		return this.bookId;
	}

	public void setBookId(Integer bookId)
	{
		this.bookId = bookId;
	}
	
	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public Date getPublishDate()
	{
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate)
	{
		this.publishDate = publishDate;
	}
	
	public String getIsbn()
	{
		return this.isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
	
	public Integer getRating()
	{
		return this.rating;
	}

	public void setRating(Integer rating)
	{
		this.rating = rating;
	}
}
