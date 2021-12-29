<%@page import="com.lucene.book.model.Book"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty requestScope.book }">

	</c:if>
	<form action="UpdateBookServlet?id=${book.id }" method="post">
		<table border="1" align="center">
			<%--<tr>
				<th>ID:</th>
				<th><input type="text" name="id" value="${book.id }"></th>
			</tr> --%>
			<tr>
				<th>识别码:</th>
				<th><input type="text" name="isbn" value="${book.isbn }"></th>
			</tr>
			<tr>
				<th>书名:</th>
				<th><input type="text" name="bookname"
					value="${book.bookname }"></th>
			</tr>
			<tr>
				<th>页数:</th>
				<th><input type="text" name="pages" value="${book.pages }"></th>
			</tr>
			<tr>
				<th>作者:</th>
				<th><input type="text" name="author" value="${book.author }"></th>
			</tr>
			<tr>
				<th>出版社:</th>
				<th><input type="text" name="press" value="${book.press }"></th>
			</tr>
			<tr>
				<th>价格:</th>
				<th><input type="text" name="price" value="${book.price }"></th>
			</tr>
			<tr>
				<th><input type="submit" value="更新"
					style="width: 100px; height: 60px"></th>
				<th><a href="showAllBooks.jsp">取消</a></th>
			</tr>
		</table>
	</form>

</body>
</html>