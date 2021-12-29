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

@WebServlet("/PreUpdateBookServlet")
public class PreUpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));


		BookService bookService = new BookService();
		Book book = bookService.FindBookById(id);

		if (book != null) {
			request.setAttribute("book", book);
			request.setAttribute("id", id);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} else {
			out.print("没有检索到");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
