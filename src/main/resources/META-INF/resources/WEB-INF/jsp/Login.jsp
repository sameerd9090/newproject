<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Maai</title>
</head>
<body style = "background: green">
<h1 align = "center">Maai</h1>
  <div align="center" style="background: brown; margin-left:50px; margin-right:50px; margin-top:20px">
  <form method = "post" action="login" style="margin-top:20px">
     <span>Username:</span><input type="text" name="userEmail" style="margin-top:20px"><br><br>
    Password: <input type = "password" name = "userPassword"><br><br>
     <input type = "submit" value = "login" style="margin-bottom:20px; margin-left:60px; color:blue">
  </form>
  </div>
  <div align="center">
  <h1><b>${message}</b></h1>
  </div>
     
</body>
</html>