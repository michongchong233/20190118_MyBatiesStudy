<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 核心標簽 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>selectAllUser.jsp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("a").click(function() {
			//parent()父標簽
			//prev()第一個兄弟標簽
			//jquery中規笵，對象名以$開 頭
			var $td = $(this).parent().next();//下一個兄弟標簽
			//html()返回值字符串
			$td.html(parseInt($td.html()) + 1);
		});
	})
</script>
</head>
<body>
	<h3>selectAllUser.jsp</h3>
	<hr>
	<table>
		<tr>
			<th>id</th>
			<th>username</th>
			<th>password</th>
			<th>photo</th>
			<th>DOWNLOAD</th>
			<th>downloadNum</th>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td>${user.photo }</td>
				<td><a href="doDownloadFile?fileName=${user.photo }">DOWNLOAD</a></td>
				<td>${user.downloadNum }</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>