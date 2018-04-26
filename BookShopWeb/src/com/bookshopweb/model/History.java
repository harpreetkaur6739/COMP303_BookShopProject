package com.bookshopweb.model;

import com.bookshopweb.model.Book;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: History
 *
 */
@Entity
@Table(name="history", schema="comp303project")
@NamedQueries({	
	@NamedQuery(name="History.Recent",
		query="SELECT h FROM History h ORDER BY h.date DESC"),
})
public class History implements Serializable
{
	private Integer historyId;
	private Book book;
	private Timestamp date;
	private String ip;
	private static final long serialVersionUID = 1L;

	@Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bookId")
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
