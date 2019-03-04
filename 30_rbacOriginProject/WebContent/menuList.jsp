<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	<!-- 調用controller -->
	$(function() {
		$.post("menuList", function(data) {
			var result = "";
			for (var i = 0; i < data.length; i++) {
				result += "<dl>";
				result += "<dt>" + data[i].name + "</dt>";
				for (var j = 0; j < data[i].child.length; j++) {
					result += "<dd>" + data[i].child[j].name + "</dd>";
				}
				result += "</dl>";
			}
			$("body").html(result);
		});
	})
	
	<!-- 對所有父菜單添加點擊事件 -->
	<!-- live("事件名，多個事件使用空格分割", function(){}) -->
	$("dt").live("click", function(){
		$(this).siblings().slideToggle(1000);
	})
	
</script>
<title>menuList.jsp</title>
</head>
<body>
	<h3>menuList.jsp</h3><hr>
	<button>權限01</button>
	<button eleno="ground">權限02</button>
	
</body>
</html>