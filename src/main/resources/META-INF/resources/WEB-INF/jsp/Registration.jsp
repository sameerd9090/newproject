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
	<form method="post" action="test">
		<h2 align="center">Registration Page</h2>
		<div align="center">
			First name:<input type="text" name="userName"><br><br> 
			Email:<input type="email" name = "userEmail"><br><br> 
			Password:  <input type="password" name = "userPassword"><br><br> 
<input type="submit" value="submit">
		</div>
	</form>
</body>
</html>