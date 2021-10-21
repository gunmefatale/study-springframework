<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		<h1> test page </h1>
		
		<h3> count : ${count} </h3>
		<h3> maxAge : ${maxAge} </h3>
		<%-- <h3> userList : ${userList} </h3> --%>
		
		<c:forEach var="user" items="${userList}" varStatus="status">
			<h4> ${status.count} : ${user.id} / ${user.pw} / ${user.age} / ${user.reg} </h4>
		</c:forEach>
		
		<h3> user : ${userOne.id} / ${userOne.pw} / ${userOne.age} / ${userOne.reg} </h3>
		
		<h3> java's reg  : ${reg} </h3>
		
		<h3> insert result : ${res} </h3>
		
	</body>
</html>