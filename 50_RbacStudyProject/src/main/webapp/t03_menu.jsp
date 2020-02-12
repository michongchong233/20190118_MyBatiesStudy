<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>t01_menu</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	//調用controller
	$(function() {
		$.post("getMenuList_03", function(data) {
			var result = "";
			for (var i = 0; i < data.length; i++) {
				result += "<dl>";
				result += "<dt>" + data[i].menuName + "</dt>";
				for (var j = 0; j < data[i].menus.length; j++) {
					result += "<dd>" + data[i].menus[j].menuName + "</dd>";
				}
				result += "</dl>";
			}
			$("body").html(result);
		});
	})

	//對所有父菜單添加點擊事件 
	//live("事件名，多個事件使用空格分割", function(){})
	$("dt").live("click", function() {
		$(this).siblings().slideToggle(1000);
	})
</script>
</head>
<body>

</body>
</html>