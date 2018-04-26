package com.bookshopweb.model;

import java.io.Serializable;

public class BookWithAuthor implements Serializable {
	public Book book;
	public Author author;
	
	public BookWithAuthor(Book book, Author author) {
		this.book = book;
		this.author = author;
	}
	
	public Book getBook() {
		return this.book;
	}
	
	public Author getAuthor() {
		return this.author;
	}
	
	public boolean isAdded() {
		return this.book != null;
	}
}
