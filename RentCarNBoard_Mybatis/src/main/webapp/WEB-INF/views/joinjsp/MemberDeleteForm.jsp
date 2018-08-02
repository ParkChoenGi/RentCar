<%@page import="java.sql.SQLException"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버업데이트</title>
</head>
<body>
	
	<center>
		<h1>회원탈퇴하기</h1>
			<table border="1" width="500">
		<form action="MemberDeleteProc" method="post">
				<tr height="50" align="center">
					<td  bgcolor="#cccccc">아이디</td>
					<td>${dto.id}</td>
				</tr>
				<tr height="50" align="center">
					<td bgcolor="#cccccc">패스워드</td>
					<td><input type="password" name="pass" size="40"></td>
				</tr>
				<input type="hidden" name="id" value="${dto.id}"></td>
				<tr height="50" bgcolor="lightgreen" align="center">
					<td colspan="2">
						<input type="submit" value="탈퇴하기"></form>
						<button onclick="location.href='MemberInfo?id=${dto.id}'">취소하기</button>
					</td>
				</tr>

			</table>
	</center>
</body>
</html>
