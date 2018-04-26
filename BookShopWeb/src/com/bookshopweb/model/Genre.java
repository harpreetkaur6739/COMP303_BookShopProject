package com.bookshopweb.model;

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
@Table(name="genres", schema="comp303project")
@NamedQueries({	
	@NamedQuery(name="Genre.All",
		query="SELECT g FROM Genre g ORDER BY g.name"),
	@NamedQuery(name="Genre.Search",
		query="SELECT g FROM Genre g WHERE g.name LIKE :query ORDER BY g.name"),
})
public class Genre implements Serializable, Comparable<Genre>
{
	private Integer genreId;
	private String name;
	private Set<Book> books;
	private static final long serialVersionUID = 1L;
	
	@Access(AccessType.PROPERTY)
	@ManyToMany
	@JoinTable(name = "bookgenres",
		joinColumns = { @JoinColumn(name = "genreId") },
		inverseJoinColumns = { @JoinColumn(name = "bookId") })
	public Set<Book> getBooks()
	{
		return this.books;
	}
	
	public void setBooks(Set<Book> books)
	{
		this.books = books;
	}

	public Genre()
	{
		super();
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Override
	public int compareTo(Genre o)
	{
		return this.name.compareTo(o.name);
	}
}
