package com.bookshopjpa.model;

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
@NamedQueries({	
	@NamedQuery(name="Author.All",
		query="SELECT a FROM Author a"),
})
public class Author implements Serializable
{
	private Integer authorId;
	private String firstName;
	private String lastName;
	private Set<Book> books;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "BookAuthors",
		joinColumns = { @JoinColumn(name = "authorId") },
		inverseJoinColumns = { @JoinColumn(name = "bookId") })
	public Set<Book> getBooks()
	{
		return this.books;
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
}
