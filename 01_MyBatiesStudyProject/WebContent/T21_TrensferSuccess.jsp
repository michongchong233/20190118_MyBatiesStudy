<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- 核心標簽 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T21_TrensferSuccess.jsp</title>
</head>
<body>
	<h3>T21_TrensferSuccess.jsp</h3><hr>
	<a href="T20_Account.jsp">我要轉帳</a>
	<table>
		<tr>
			<th>交易序號</th>
			<th>轉出帳戶</th>
			<th>轉入帳戶</th>
			<th>轉帳金額</th>
			<th>交易時間</th>
		</tr>
		<c:forEach items="${transferLog}" var="log">
		<tr>
			<td>${log.transfer_id}</td>
			<td>${log.out_account}</td>
			<td>${log.in_account}</td>
			<td>${log.transfer_money}</td>
			<td>${log.transfer_datetime}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>