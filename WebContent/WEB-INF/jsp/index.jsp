<!--2.top화면  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>
	<h1>welcome to visit</h1>
	<!--정보 송신할 곳을 설정-->
	<form action="/board/Login" method="post">
		Username:<input type="text" name="name"><br> Password:<input
			type="password" name="pass"><br> <input type="submit"
			value="LOGIN">
	</form>
</body>
</html>