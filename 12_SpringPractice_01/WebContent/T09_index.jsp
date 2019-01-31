<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T09_index.jsp</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("a").click(function() {
			//瀏覽器自帶緩存功能，它不會多次請求相同數據
			$("img").attr("src", "09_02_test?date=" + Math.random());
			return false;
		})
	})
</script>
</head>
<body>
	<h3>T09_index.jsp</h3>
	<hr>

	<form action="10_test">
		<!-- <img src="09_01_test"><!-- 使用Servlet響應圖片異步請求 -->
		user name:<input type="text" name="uname" value=""><br>
		password:<input type="password" name="password" value=""><br>
		code:<input type="text" name="userCode"> <img src="09_02_test" height="40">
		<a href="">reset code</a><br> <input type="submit" value="submit">
		<input type="reset" value="reset">
	</form>

</body>
</html>