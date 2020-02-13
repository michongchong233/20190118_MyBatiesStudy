<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 核心標簽 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>t01_menu</title>
</head>
<body>
	<p>${user.username }</p>

	<dl>
		<c:forEach items="${user.menus }" var="menu">
			<dt>${menu.menuName }</dt>
			<c:forEach items="${menu.menus }" var="child">
				<dd>${child.menuName }</dd>
			</c:forEach>
		</c:forEach>
	</dl>

	<c:forEach items="${user.elements}" var="element">
		<c:if test="${element.elementStr eq 'ins' }">
			<button elementStr="ins">insert</button>
		</c:if>
	</c:forEach>
	<button>select</button>
</body>
</html>