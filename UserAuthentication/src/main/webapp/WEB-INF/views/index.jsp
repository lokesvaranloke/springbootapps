<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Authentication</title>
</head>
<body>
	<h1>User Registration Form</h1>
	<form action="adduser" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr><td><input type="submit" value="Register"></td></tr>
			<tr><a href="viewusers">View All Users</a></tr>
		</table>
	</form>
	
</body>
</html>