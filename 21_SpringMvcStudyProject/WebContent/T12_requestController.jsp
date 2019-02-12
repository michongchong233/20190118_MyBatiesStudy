<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>T12_requestController.jsp</title>
</head>
<body>
	request: ${requestScope.request }<br>
	session: ${sessionScope.session }<br>
	sessionParam: ${sessionScope.sessionParam }<br>
	servletContext: ${applicationScope.application }<br>
	<hr>
	map: ${requestScope.map }<br>
	<hr>
	model: ${requestScope.model }<br>
	<hr>
	ModelAndView: ${requestScope.mav }<br>
</body>
</html>