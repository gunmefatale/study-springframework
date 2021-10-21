<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>updatePro</title>
	</head>
	<body>
	
		<h1> updatePro </h1>
		
		<c:if test="${result == 1}">
			<h3> ${testDTO.id} 님, 회원 수정 완료 </h3>
		</c:if>
		
		<c:if test="${result != 1}">
			<script>
				alert("수정 실패...");
				history.go(-1);
			</script>
		</c:if>
	
	</body>
</html>