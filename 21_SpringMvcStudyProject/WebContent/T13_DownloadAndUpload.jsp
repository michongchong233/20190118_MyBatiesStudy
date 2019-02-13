<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T13_DownloadAndUpload.jsp</title>
</head>
<body>
	<h3>T13_DownloadAndUpload.jsp</h3><hr>
	class 13<br>
	<a href="downloadFile?fileName=T13_FileDownload.txt">download</a><br>
	class 14<br>
	<form action="uploadFile" enctype="multipart/form-data" method="post">
		姓名：<input type="text" name="name"><br>
		文件：<input type="file" name="file"><br>
		<input type="submit" value="submit">
	</form>

</body>
</html>