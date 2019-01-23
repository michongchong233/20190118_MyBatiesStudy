<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T21_CreateUser.jsp</title>
</head>
<body>
<h3>T21_CreateUser.jsp</h3><hr>
<a href="T20_showPage.jsp">用戶列表</a>
<form action="21_test" method="get">
	<table>
	<tr>
		<td>uname</td>
		<td><input type="text" name="uname" value="" /></td>
	</tr>
	<tr>
		<td>password</td>
		<td><input type="password" name="password" value="" /></td>
	</tr>
	<tr>
		<td>gender</td>
		<td><input type="text" name="gender" value="" /></td>
	</tr>
	<tr>
		<td>age</td>
		<td><input type="text" name="age" value="" /></td>
	</tr>
</table>
<input type="submit" />
</form>

</body>
</html>