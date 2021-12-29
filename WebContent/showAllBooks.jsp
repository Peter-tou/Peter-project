

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/validate.js"></script>
</head>
<body>
	<h1 align="center">所有图书信息如下</h1>
	&nbsp;
	<h3 align="center">
		<a href="addBook.html">添加图书</a>
	</h3>
	<hr>
	<table border="2" align="center">
		<tr>
			<td align="center">ID</td>
			<td align="center">书名</td>
			<td align="center">ISBN</td>
			<td align="center">作者</td>
			<td align="center">出版社</td>
			<td align="center">页数</td>
			<td align="center">价格</td>
			<td align="center">更新</td>
			<td align="center">删除</td>
		</tr>
		<c:if test="${empty requestScope.bookList}">
			<script>
				location.href = "SelectAllBooksServlet"
			</script>
		</c:if>


		<c:forEach items="${ requestScope.bookList }" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.bookname}</td>
				<td>${book.isbn}</td>
				<td>${book.author}</td>
				<td>${book.press}</td>
				<td>${book.pages}</td>
				<td>${book.price}</td>
				<td align="center"><a href="PreUpdateBookServlet?id=${book.id}">更新</a></td>
				<td align="center"><a href="DeleteBookServlet?id=${book.id}"
					onclick="return deleteRecord();">删除</a></td>

			</tr>
		</c:forEach>

	</table>


</body>
</html>