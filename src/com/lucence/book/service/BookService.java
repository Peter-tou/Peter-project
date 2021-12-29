package com.lucence.book.service;

import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.lucene.book.dao.BookDao;
import com.lucene.book.dbutil.ConnectionManager;
import com.lucene.book.model.Book;

public class BookService {
	public int addBook(final Book book) {
		// 创建连接对象
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();

		BookDao bookDao = new BookDao();
		int affectedRows = -1;
		try {
			affectedRows = bookDao.insertBook(book, connection);
			return affectedRows;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return affectedRows;
		} finally {
			// 关闭连接对象
			connectionManager.closeConnection(connection);
		}
	}

	public List<Book> FindAllBooks() {
		// 创建连接对象
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		List<Book> bookList = new ArrayList<Book>();
		BookDao bookDao = new BookDao();
		try {
			ResultSet rs = bookDao.selectAllBooks(connection);
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setIsbn(rs.getString("Isbn"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setPages(rs.getInt("pages"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getDouble("price"));

				bookList.add(book);
			}
			return bookList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			// 关闭连接对象
			connectionManager.closeConnection(connection);
		}
	}

	public Book FindBookById(final int id) {
		// 创建连接对象
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		BookDao bookDao = new BookDao();
		Book book = null;

		try {
			ResultSet rs = bookDao.selectBookById(id, connection);
			if (rs.next()) {
				book = new Book();
				book.setId(id);
				book.setIsbn(rs.getString(2));
				book.setBookname(rs.getString(3));
				book.setPages(rs.getInt(4));
				book.setAuthor(rs.getString(5));
				book.setPress(rs.getString(6));
				book.setPrice(rs.getDouble(7));

				return book;

			} else {
				return book;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return book;
		} finally {
			// 关闭连接对象
			connectionManager.closeConnection(connection);
		}
	}

	public int removeBookById(final int id) {
		// 创建连接对象
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();

		BookDao bookDao = new BookDao();
		int affectedRows = -1;
		try {
			affectedRows = bookDao.deleteBookById(id, connection);
			return affectedRows;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return affectedRows;
		} finally {
			// 关闭连接对象
			connectionManager.closeConnection(connection);
		}

	}

	public int updateBookById(final Book book, final int id) {
		// 创建连接对象
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();

		BookDao bookDao = new BookDao();
		int affrectedRows = -1;
		try {
			affrectedRows = bookDao.updateBookById(book, id, connection);
			return affrectedRows;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return affrectedRows;
		} finally {
			// 关闭连接对象
			connectionManager.closeConnection(connection);
		}

	}

}
