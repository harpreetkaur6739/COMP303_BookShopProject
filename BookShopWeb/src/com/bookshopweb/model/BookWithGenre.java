package com.bookshopweb.model;

import java.io.Serializable;

public class BookWithGenre implements Serializable {
	public Book book;
	public Genre genre;
	
	public BookWithGenre(Book book, Genre genre) {
		this.book = book;
		this.genre = genre;
	}
	
	public Book getBook() {
		return this.book;
	}
	
	public Genre getGenre() {
		return this.genre;
	}
	
	public boolean isAdded() {
		return this.book != null;
	}
}
