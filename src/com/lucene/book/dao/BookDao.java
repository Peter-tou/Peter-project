package com.lucene.book.dao;

import java.sql.*;

import com.lucene.book.model.Book;

import com.lucene.book.dbutil.SQLManager;

public class BookDao {
	// 定义一个完成图书添加的方法
	public int insertBook(final Book book, final Connection connection) throws Exception {

		String isbn = book.getIsbn();
		String bookname = book.getBookname();
		int pages = book.getPages();
		String author = book.getAuthor();
		String press = book.getPress();
		double price = book.getPrice();

		SQLManager sqlManager = new SQLManager();
		String strSQL = "insert into book(isbn,bookname,pages,author,press,price) values(?,?,?,?,?,?)";
		Object[] params = new Object[] { isbn, bookname, pages, author, press, price };
		int affectedRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectedRows;

	}

	// 查询所有图书信息的方法
	public ResultSet selectAllBooks(final Connection connection) throws Exception {

		String strSQL = "select * from book";
		Object[] params = new Object[] {};
		SQLManager sqlManager = new SQLManager();
		ResultSet rs = sqlManager.execQuery(connection, strSQL, params);
		return rs;

	}

	// 查询指定id的图书信息
	public ResultSet selectBookById(final int id, final Connection connection) throws Exception {

		String strSQL = "select * from book where id=?";
		Object[] params = new Object[] { id };
		SQLManager sqlManager = new SQLManager();
		ResultSet rs = sqlManager.execQuery(connection, strSQL, params);
		return rs;
	}

	// 更新指定id的图书信息
	public int updateBookById(final Book book, final int id,final Connection connection) throws Exception{

		// 获取图书各个新数据
		String isbn = book.getIsbn();
		String bookname = book.getBookname();
		int pages = book.getPages();
		String author = book.getAuthor();
		String press = book.getPress();
		double price = book.getPrice();


		SQLManager sqlManager = new SQLManager();
		String strSQL = "update book set isbn=?,bookname=?,pages=?,author=?,press=?,price=? where id=?";
		Object[] params = new Object[] { isbn, bookname, pages, author, press, price, id };

		int affwordsRows = sqlManager.execUpdate(connection, strSQL, params);
		return affwordsRows;
	}

	// 删除指定id的图书信息
	public int deleteBookById(final int id,final Connection connection) throws Exception{
		

		String strSQL = "delete from book where id=?";
		Object[] params = new Object[] { id };
		SQLManager sqlManager = new SQLManager();
		int affectedRows = sqlManager.execUpdate(connection, strSQL, params);
		return affectedRows;
	}
}
