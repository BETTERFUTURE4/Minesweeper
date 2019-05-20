<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page session="false"%>
<html>
<head>
<title>update</title> 
</head>
<body>
	<h1>Hello Simple GuestBook world!!</h1>

	<form action="/updateRequest" method="post">
		<input name="guestbookId" type="hidden" value="${guestbook.guestbookId}">
		<p>
			제목 : <input name="title" type="text" value="${guestbook.title}">
		</p>
		<p>
			내용 : <input name="content" type="text" value="${guestbook.content}">
		</p>
		<p>
			비번 : <input name="password" type="text">
		</p>
		<input type="submit">
	</form>

</body>
</html>
