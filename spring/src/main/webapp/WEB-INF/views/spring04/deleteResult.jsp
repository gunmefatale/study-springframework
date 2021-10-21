<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>deleteResult</title>
	</head>
	<body>
	
		<h1> deleteResult page </h1>
		
		<c:if test="${result == 1}">
			<script>
				alert("삭제완요!");
			</script>
		</c:if>
		
		<c:if test="${result != 1}">
			<script>
				alert("삭제 실패. 정보를 다시 확인하세요.");
				history.go(-1);
			</script>
		</c:if>
	
	</body>
</html>