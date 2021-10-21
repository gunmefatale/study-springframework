<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		<h1> hello spring!!! </h1>	
		
		<h3> id : ${id} </h3>
		<h3> pw : ${pw} </h3>
		<br />
		<h3> id : ${requestScope.id} </h3>
		<h3> pw : ${requestScope.pw} </h3>
		<br />
		<h3> dto.id : ${dto.id} </h3>
		<h3> dto.pw : ${dto.pw} </h3>
		<br />
		<h3> SampleDTO.id : ${sampleDTO.id} </h3>
		<h3> SampleDTO.pw : ${sampleDTO.pw} </h3>
		<br />
		<h3> tvDTO : ${tvDTO} </h3>
		<h3> tvDTO.power : ${tvDTO.power} </h3>
		<h3> tvDTO.ch : ${tvDTO.ch} </h3>
		<h3> tvDTO.color : ${tvDTO.color} </h3>
		<br />
		<h3> tv : ${tv} </h3>
		<h3> tv.power : ${tv.power} </h3>
		<h3> tv.ch : ${tv.ch} </h3>
		<h3> tv.color : ${tv.color} </h3>
			
	</body>
</html>