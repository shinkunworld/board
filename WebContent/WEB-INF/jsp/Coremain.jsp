<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
</head>
<body>
	<h1>main</h1>
	<p>
		<c:out value="${loginUser.name }" />
		さん、loginしました <a href="/board/Logout">Logout</a>
	<p>
	<p>
		<a href="<%=request.getContextPath()%>/Main">更新</a>
		<!-- 프로젝트명이 바껴도 자동 갱신이됨 -->
	</p>
	<form action="Main" method="post">
		<input type="text" name="text"> <input type="submit"
			value="board">
	</form>
<c:if test="${not empty errorMsg}">
<p>${errorMsg }</p>
</c:if>

<c:forEach var="mutter" items="${mutterList}">
<p><c:out value="${mutter.userName }"/>
<c:out value="${mutter.text }"/>
</p></c:forEach>

</body>
</html>