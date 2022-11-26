<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
table, th, td {
  border:1px solid black;
}
</style>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th> User Id</th>
<th> User Name</th>
<th> User Email</th>
<th> User Password</th>
</tr>
<c:forEach var="item" items="${allusers}" >
<tr>
   <td> ${item.userId} </td>
   <td> ${item.userName}</td>
   <td> ${item.userEmail}</td>
   <td> ${item.userPassword}</td>
   </tr>
</c:forEach>
</table>
</body>
</html>