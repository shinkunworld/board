<!-- 로그인결과를 화면에 출력 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%
	//session からUSER情報を取得
	User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>
	<h1>Login</h1>
	<%
		if (loginUser != null) {
	%>
	<p>sucess Login</p>
	<p>
		welcome<%=loginUser.getName()%>さん
	</p>
	<a href="/board/Main">write</a>
	<%
		} else {
	%>
	<p>fail Login</p>
	<a href="/board">Top</a>
	<%
		}
	%>
</body>
</html>