<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T20_Account</title>
</head>
<body>
	<h3>T20_Account</h3><hr>
	<a href="22_test">查看記錄</a>
	<form action="21_account" method="post">
		<table>
			<tr>
				<td>轉賬帳戶</td>
				<td><input type="text" name="OutAccName" value="" /></td>
			</tr>
			<tr>
				<td>轉賬帳戶密碼</td>
				<td><input type="text" name="OutPassword" value="" /></td>
			</tr>
			<tr>
				<td>金額</td>
				<td><input type="text" name="money" value="" /></td>
			</tr>
			<tr>
				<td>收款帳號</td>
				<td><input type="text" name="InAccName" value="" /></td>
			</tr>
			<tr>
				<td>收款者姓名</td>
				<td><input type="text" name="InName" value="" /></td>
			</tr>
		</table>
		<input type="submit">
	</form>


</body>
</html>