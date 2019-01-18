<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create User</title>
</head>
<body>
<h3>Create User</h3><hr>
	<form action="http://localhost:8080/00_OriginWebProjectFor8/createUser" method="post">
		<table>
			<tr>
				<td>uname:</td>
				<td><input type="text" name="uname" value=""></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td>gender:</td>
				<td><input type="text" name="gender" value=""></td>
			</tr>
			<tr>
				<td>age:</td>
				<td><input type="text" name="age" value=""></td>
			</tr>
		</table>
		<input type="submit" value="submit">
	</form>
</body>
</html>