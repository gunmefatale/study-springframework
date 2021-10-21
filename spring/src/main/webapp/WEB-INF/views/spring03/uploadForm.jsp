<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>file uploadFrom</title>
	</head>
	<body>
		
		<h1> uploadForm.jsp </h1>
		
		<form action="/spring/upload/uploadPro.git" method="post" enctype="multipart/form-data">
			name : <input type="text" name="name">		<br />
			img : <input type="file" name="img">		<br />
				  <input type="submit" value="send">	<br />
		</form>
		
	</body>
</html>