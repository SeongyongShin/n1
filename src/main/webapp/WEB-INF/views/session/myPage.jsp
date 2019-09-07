<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1><br>
	${sessionScope.user_id }<br>
	<h2>(${sessionScope.user_name})</h2>님 환영합니다.
	<a href="loginPage">정보 수정</a>
	<a href="logout">로그아웃</a>
</body>
</html>