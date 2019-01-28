<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 核心標簽 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T27_ShowPage</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- EL表達式可以寫在整個jsp文件中(包含<script>和<style>標簽) -->
<script type="text/javascript">
	$(function() {
		var pageSizeStr = "${pageInfo.pageSize}";//代表字符串
		var pageStartStr = "${pageInfo.pageStart}";
		var pageNumber = "${pageInfo.pageNumber}";
		var tname = "${pageInfo.tname}";
		var sname = "${pageInfo.sname}";

		//讓js選擇當前的pageSize
		//i表示循環角標，n表示迭代變量(數組的第i個)；其中n是dom對象
		//dom對象，表示js對象
		//dom對象轉換為jquery對象：$(dom對象)
		//jquery對象轉換為dom對象：jquery對象[0]或jquery對象.get(0)
		//轉換的目的在於使用這個對象的方法和屬性
		$.each($(":radio"), function(i, n) {//對表單進行循環遍歷，jquery提供遍歷jquery數組的方式
			if ($(n).val() == pageSizeStr) {
				$(n).attr("checked", "checked");
			}
		});

		//對輸入框設置值
		//jquery之所以設置如此之多的選擇器，是為了讓程序員盡可能少地設置id屬性
		$(":text[name='sname']").val(sname);//屬性選擇器
		$(":text[name='tname']").val(tname);

		//搜索button點野事件
		$("button").click(
				function() {
					$(location).attr('href',"27_test?pageSizeStr=" + pageSizeStr
							+ "&pageNumberStr=1&tname="
							+ $(":text[name='tname']").val() + "&tname="
							+ $(":text[name='sname']").val());
				});

	});
</script>
</head>
<body>
	<h3>T27_ShowPage</h3>
	<hr>
	pageSize:
	<input type="radio" name="pageSizeStr" value="2">2
	<input type="radio" name="pageSizeStr" value="3">3
	<input type="radio" name="pageSizeStr" value="4">4
	<br> student name:
	<input type="text" name="sname" value=""> teacher name:
	<input type="text" name="tname" value="">
	<button>search</button><br>

	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
			<th>teacher</th>
		</tr>
		<c:forEach items="${pageInfo.list}" var="student">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.age}</td>
				<td>${student.teacher.tname}</td>
			</tr>
		</c:forEach>
	</table>
	<a>上一頁</a>
	<a>下一頁</a>
</body>
</html>