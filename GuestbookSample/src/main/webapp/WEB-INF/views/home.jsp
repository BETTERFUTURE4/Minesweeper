<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>


<body>
	<h1>Hello Simple GuestBook world!!</h1>

	<table border="1">
		<c:forEach var="result" items="${guestbooks}" varStatus="status">
			<tr>
				<td align="left"><c:out value="${result.guestbookId}" /></td>
				<td align="center"><c:out value="${result.title}" /></td>
				<td align="center"><c:out value="${result.content}" /></td>
				<td align="center"><c:out value="${result.registerDate}" /></td>
				<!-- update 버튼  -->
				<td align="center"> <a href="/update/${result.guestbookId}"> update</a> </td>
			</tr>
		</c:forEach>
	</table>

	<form action="/write" method="post">
		<p>
			제목 : <input name="title" type="text">
		</p>
		<p>
			내용 : <input name="content" type="text">
		</p>
		<p>
			비번 : <input name="password" type="text">
		</p>
		<input type="submit">
	</form>


</body>
</html>
