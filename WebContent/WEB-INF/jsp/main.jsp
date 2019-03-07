<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.User,model.Mutter,java.util.List"%>
<%
	//sessionに保存されたuser情報習得
	User loginUser = (User) session.getAttribute("loginUser");
	//applicaionに保存
	List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
	String errorMsg = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
</head>
<body>
	<h1>main</h1>
	<p>
		<%=loginUser.getName()%>さん、loginしました <a href="/board/Logout">Logout</a>
	<p>
	<p>
		<a href="<%=request.getContextPath()%>/Main">更新</a>
		<!-- 프로젝트명이 바껴도 자동 갱신이됨 -->
	</p>
	<form action="Main" method="post">
		<input type="text" name="text"> <input type="submit"
			value="board">
	</form>
	<%
		if (errorMsg != null) {
	%>
	<p><%=errorMsg%></p>
	<%
		}
	%>
	<%
		for (Mutter mutter : mutterList) {
	%>
	<p><%=mutter.getUserName()%>:<%=mutter.getText()%></p>
	<%
		}
	%>
</body>
</html>