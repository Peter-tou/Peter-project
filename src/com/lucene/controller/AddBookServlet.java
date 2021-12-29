package com.lucene.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucence.book.service.BookService;

import com.lucene.book.model.Book;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		// 通过request获取表单数据
		String isbn = request.getParameter("isbn");
		String bookname = request.getParameter("bookname");
		int pages = Integer.parseInt(request.getParameter("pages"));
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		double price = Double.parseDouble(request.getParameter("price"));

		Book book = new Book(isbn, bookname, pages, author, press, price);

		BookService bookService = new BookService();

		int result = bookService.addBook(book);

		if (result > 0) {
			out.println("<script>alert('图书信息添加成功');window.location.href='SelectAllBooksServlet'</script>");
		} else {
			out.println("<script>alert('图书信息添加失败，请重新添加。');window.location.href='addBook.html'</script>");
		}

	}

}
