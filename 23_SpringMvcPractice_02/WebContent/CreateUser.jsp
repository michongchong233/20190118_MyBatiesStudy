<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>CreateUser.jsp</title>
</head>
<body>
	<h3>CreateUser.jsp</h3><hr>
	<form action="createUser" enctype="multipart/form-data" method="post">
		username:<input type="text" name="username" value=""><br>
		password:<input type="password" name="password" value=""><br>
		photo:<input type="file" name="file" value=""><br>
		<input type="submit" value="submit">
	</form>

</body>
</html>