<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
pageContext.setAttribute("aa", "hello");
%>
<body>

 	<%= request.getAttribute("result") %> 입니다.
		${result} <br>
		${notice.title} <br>
		${names[1]} <br>
		${aa} <br>
		${param.n} <br>
		${header.accept} <br>
		${param.n > 3} <br> <!-- 비교연산자를 사용했기 때문에 true 또는 false 가 나온다. -->
		${param.n ge 3} <br> <!-- 꺾음새 대신에 ge를 사용한다. -->
</body>
</html>