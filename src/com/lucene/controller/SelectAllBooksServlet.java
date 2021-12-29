package com.lucene.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lucence.book.service.BookService;

import com.lucene.book.model.Book;

@WebServlet("/SelectAllBooksServlet")
public class SelectAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		BookService bookService = new BookService();

		List<Book> bookList = bookService.FindAllBooks();
		if (bookList.size() > 0) {
			
			request.setAttribute("bookList", bookList);
			request.getRequestDispatcher("showAllBooks.jsp").forward(request,response);
			
		} else {
			out.print("<script>alert('没有图书信息，请添加。');window.location.href='addBook.html'</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
