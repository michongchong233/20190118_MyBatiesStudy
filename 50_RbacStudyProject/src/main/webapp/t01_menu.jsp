<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>t01_menu</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	//�ե�controller
	$(function() {
		$.post("getMenuList", function(data) {
			var result = "";
			for (var i = 0; i < data.length; i++) {
				result += "<dl>";
				result += "<dt>" + data[i].menuName + "</dt>";
				for (var j = 0; j < data[i].children.length; j++) {
					result += "<dd>" + data[i].children[j].menuName + "</dd>";
				}
				result += "</dl>";
			}
			$("body").html(result);
		});
	})

	//��Ҧ������K�[�I���ƥ� 
	//live("�ƥ�W�A�h�Өƥ�ϥΪŮ����", function(){})
	$("dt").live("click", function() {
		$(this).siblings().slideToggle(1000);
	})
</script>
</head>
<body>

</body>
</html>