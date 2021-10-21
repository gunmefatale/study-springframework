<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>insertForm</title>
	</head>
	<body>
	
		<h2> insertForm page </h2>
		
		<form action="/spring/mybatis/insertPro.git" method="post">
			id :  <input type="text" name="id" />			<br />
			pw :  <input type="password" name="pw" />		<br />
			age : <input type="text" name="age" />			<br />
				  <input type="submit" value="join" />		<br />
		</form>
	
	
	</body>
</html>