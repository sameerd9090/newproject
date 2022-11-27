<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
table, th, td {
	border: 2px solid black;
	background-color: yellow;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: pink">
	<div align="center" style="color: Black">
		<h1>${message}</h1>
		<h1>${message0}</h1>
	</div>
	<div align="center" style="color: red">
		<h2>Users List</h2>
	</div>
	<div style="background-color:green; margin-top:100px;">
		<table align="center" style="color: black; margin-top:10px;">
			<tr>
				<th>User Id</th>
				<th>User Name</th>
				<th>User Email</th>
				<th>User Password</th>
				<th>Delete User</th>
			</tr>
			<c:forEach var="item" items="${allusers}">
				<tr>
					<td>${item.userId}</td>
					<td>${item.userName}</td>
					<td>${item.userEmail}</td>
					<td>${item.userPassword}</td>
					<td><a href="<c:url value='/delete/${item.userId}'/>">Delete</a></td>			
					</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>