<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>select</title>
	</head>
	<body>
		<%-- 4-4 selec.jsp 페이지 만들기 --%>
		<%-- 5 mybatisSQL.xml > sql문 <select> 태그 만들어주기. --%>
		<h1> select page </h1>
		
		<%-- 6-3 webapp > WEB-INF > views > spring05 > select.jsp에 model.addAttribute("result", result); 넘겨준 값 확인하기. --%>
		<%-- 7 src > test.spring.mybatis > TestMybatis2.java > <select> 추가해보기 --%>
		<h3> result : ${result} </h3>
		
	</body>
</html>