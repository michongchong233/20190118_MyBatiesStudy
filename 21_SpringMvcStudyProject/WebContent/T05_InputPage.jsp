<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T05_InputPage.jsp</title>
</head>
<body>
	<h3>T05_InputPage.jsp</h3><hr>
	<form method="post" action="06_03_test">
		name:<input type="text" name="name"><br>
		age:<input type="text" name="age"><br>
		<input type="checkbox" name="hover" value="sleeping">
		<input type="checkbox" name="hover" value="coding">
		<input type="checkbox" name="hover" value="singing">
		<input type="checkbox" name="hover" value="drawing">
		<br>
		people name:<input type="text" name="peo.name"><br>
		people age:<input type="text" name="peo.age"><br>
		<hr>
		people name:<input type="text" name="peos[0].name"><br>
		people age:<input type="text" name="peos[0].age"><br>
		people name:<input type="text" name="peos[1].name"><br>
		people age:<input type="text" name="peos[1].age"><br>
		<input type="submit" value="submit">
		<br>
	</form>
	<a href="06_04_test/Mikcey/456">06_04_test try</a>
</body>
</html>