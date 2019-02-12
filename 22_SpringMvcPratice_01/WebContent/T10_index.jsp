<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script type="text/javascript">
		alert("aaa");
		$(function(){
			$.post("showMenu", function(data){
				var result = "";
				for(var i=0;i<data.length;i++){
					result += "<dl>";
					result += "<dt>"data[i].name"</dt>";
					for(var j=0;j<data[i].child.length;j++){
						result += "<dd>"+data[i].child[j].name+"</dd>";
					}
					result += "</dl>";
				}
				$("body").html(result);
			});
		});
	</script>
	<title>T10_index.jsp</title>
</head>
<body>
	<h3>T10_index.jsp</h3><hr>
</body>
</html>