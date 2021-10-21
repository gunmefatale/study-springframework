<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>updateFrom</title>
	</head>
	<body>
	
		<form action="/spring/mybatis/updatePro.git" method="post">
			id :  ${user.id}													<br />
			pw :  <input type="password" name="pw" value="${user.pw}" />		<br />
			age : <input type="text" name="age" value="${user.age}" />			<br />
				  <input type="submit" value="edit" />							<br />
		</form>
		
		<button onclick="window.location='/spring/mybatis/deleteUser.git'">delete</button>
	
	</body>
</html>