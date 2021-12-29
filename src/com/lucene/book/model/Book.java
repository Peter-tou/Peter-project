package com.lucene.book.model;

public class Book {
	private int id;
	private String isbn;
	private String bookname;
	private int pages;
	private String author;
	private String press;
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Book(int id, String isbn, String bookname, int pages, String author, String press, double price) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.bookname = bookname;
		this.pages = pages;
		this.author = author;
		this.press = press;
		this.price = price;
	}
	public Book(String isbn, String bookname, int pages, String author, String press, double price) {
		super();
		this.isbn = isbn;
		this.bookname = bookname;
		this.pages = pages;
		this.author = author;
		this.press = press;
		this.price = price;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", bookname=" + bookname + ", pages=" + pages + ", author="
				+ author + ", press=" + press + ", price=" + price + "]";
	}
	

}
