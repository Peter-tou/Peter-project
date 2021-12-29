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

@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		// 通过request获取表单数据
		String isbn = request.getParameter("isbn");
		String bookname = request.getParameter("bookname");
		int pages = Integer.parseInt(request.getParameter("pages"));
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		double price = Double.parseDouble(request.getParameter("price"));

		Book book = new Book(isbn, bookname, pages, author, press, price);


		BookService bookService = new BookService();
		int result = bookService.updateBookById(book, id);
		if (result > 0) {
			response.sendRedirect("SelectAllBooksServlet");
		} else {
			out.println("<script>alert('更新异常');window.location.href='showAllBooks.jsp' </script>)");
		}
	}

}
