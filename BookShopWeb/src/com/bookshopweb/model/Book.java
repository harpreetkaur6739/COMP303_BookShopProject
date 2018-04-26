package com.bookshopweb.model;

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
@Table(name="books", schema="comp303project")
@NamedQueries({	
	@NamedQuery(name="Book.All",
		query="SELECT b FROM Book b"),
	@NamedQuery(name="Book.Search",
		query="SELECT b FROM Book b WHERE b.title LIKE :query"),
	@NamedQuery(name="Book.SearchAuthor",
		query="SELECT a, b FROM Author a LEFT OUTER JOIN a.books b WHERE (b IS NULL OR b.bookId = :bookId) AND (a.firstName LIKE :query OR a.lastName LIKE :query OR CONCAT(a.firstName, a.lastName) LIKE :query OR CONCAT(a.lastName, a.firstName) LIKE :query)"),
	@NamedQuery(name="Book.SearchGenre",
		query="SELECT g, b FROM Genre g LEFT OUTER JOIN g.books b WHERE (b IS NULL OR b.bookId = :bookId) AND (g.name LIKE :query)"),
	@NamedQuery(name="Book.SearchAvailable",
	query="SELECT b FROM Book b JOIN b.inventory i WHERE i.quantity > 0"),

})
public class Book implements Serializable
{
	private Integer bookId;
	private String title;
	private Date publishDate;
	private String isbn;
	private Integer rating;
	private Set<Author> authors;
	private Set<Genre> genres;
	
	private Detail detail;
	
	@OneToOne
	@JoinColumn(name="detailId")
	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	
	private Inventory inventory;
	@OneToOne
	@JoinColumn(name="inventoryId")
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Access(AccessType.PROPERTY)
	@ManyToMany
	@JoinTable(name = "bookauthors",
		joinColumns = { @JoinColumn(name = "bookId") },
		inverseJoinColumns = { @JoinColumn(name = "authorId") })
	public Set<Author> getAuthors()
	{
		return this.authors;
	}
	
	public void setAuthors(Set<Author> authors)
	{
		this.authors = authors;
	}
	
	@ManyToMany
	@JoinTable(name = "bookgenres",
		joinColumns = { @JoinColumn(name = "bookId") },
		inverseJoinColumns = { @JoinColumn(name = "genreId") })
	public Set<Genre> getGenres()
	{
		return this.genres;
	}
	
	public void setGenres(Set<Genre> genres)
	{
		this.genres = genres;
	}
	
	private static final long serialVersionUID = 1L;
	
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