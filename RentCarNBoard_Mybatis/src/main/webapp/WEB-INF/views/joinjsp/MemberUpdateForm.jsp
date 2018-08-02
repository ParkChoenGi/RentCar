
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
		<h1>회원정보수정하기</h1>
			<table border="1" width="500">
		<form action="MemberUpdateProc" method="post">
				<tr height="50" align="center">
					<td  bgcolor="#cccccc">아이디</td>
					<td>${dto.id}</td>
				</tr>
				<tr height="50" align="center">
					<td bgcolor="#cccccc">이메일</td>
					<td><input type="email" name="email" size="40"
						value="${dto.email}"></td>
				</tr>
				<tr height="50" align="center">
					<td bgcolor="#cccccc">전화</td>
					<td><input type="tel" name="tel" size="40"
						value="${dto.tel}"></td>
				</tr>
				
				
				<tr height="50" align="center">
					<td bgcolor="#cccccc">직업</td>
					<td><input type="text" name="job" size="40"
						value="${dto.job}"></td>
				</tr>
				<tr height="50" align="center">
					<td bgcolor="#cccccc">취미</td>
					<td><input type="text" name="hobby" size="40"
						value="${dto.hobby}"></td>
				</tr>
				<tr height="50" align="center">
					<td bgcolor="#cccccc">패스워드</td>
					<td><input type="password" name="pass" size="40"></td>
				</tr>
				<input type="hidden" name="id" value="${dto.id}"></td>
				<tr height="50" bgcolor="lightgreen" align="center">
					<td colspan="2">
						<input type="submit" value="저장하기"></form>
						<button onclick="location.href='MemberList'">목록보기</button>
					</td>
				</tr>

			</table>
	</center>
</body>
</html>
