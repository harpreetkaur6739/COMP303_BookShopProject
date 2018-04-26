package com.bookshopweb.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Author
 *
 */
@Entity
@Table(name="authors", schema="comp303project")
@NamedQueries({	
	@NamedQuery(name="Author.All",
		query="SELECT a FROM Author a ORDER BY a.lastName"),
	@NamedQuery(name="Author.Search",
		query="SELECT a FROM Author a WHERE a.firstName LIKE :query OR a.lastName LIKE :query OR CONCAT(a.firstName, a.lastName) LIKE :query OR CONCAT(a.lastName, a.firstName) LIKE :query ORDER BY a.lastName"),
})
public class Author implements Serializable, Comparable<Author>
{
	private Integer authorId;
	private String firstName;
	private String lastName;
	private Set<Book> books;
	private static final long serialVersionUID = 1L;
	
	@Access(AccessType.PROPERTY)
	@ManyToMany
	@JoinTable(name = "bookauthors",
		joinColumns = { @JoinColumn(name = "authorId") },
		inverseJoinColumns = { @JoinColumn(name = "bookId") })
	public Set<Book> getBooks()
	{
		return this.books;
	}
	
	public void setBooks(Set<Book> books)
	{
		this.books = books;
	}

	public Author()
	{
		super();
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAuthorId()
	{
		return this.authorId;
	}

	public void setAuthorId(Integer authorId) 
	{
		this.authorId = authorId;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Override
	public int compareTo(Author o)
	{
		return this.lastName.compareTo(o.lastName);
	}
}
