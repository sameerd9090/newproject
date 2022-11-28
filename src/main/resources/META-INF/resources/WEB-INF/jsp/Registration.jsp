<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${message}
	${updatemessage}
	<form method="post" action="update">
		<h2 align="center">Registration Page</h2>
		<div align="center">
			<c:forEach items="${userEntity}" var="blist">
			User Id: <input type="number" name="userId" value = "${blist.userId}" >
			First name:<input type="text" name="userName" value="${blist.userName}"><br>
			<br> Email:<input type="email" name="userEmail" value = "${blist.userEmail}"><br>
			<br> Password: <input type="password" name="userPassword" value = "${blist.userPassword}"><br>
			<br> <input type="submit" value="submit">
			</c:forEach>
		</div>
	</form>
</body>
</html>