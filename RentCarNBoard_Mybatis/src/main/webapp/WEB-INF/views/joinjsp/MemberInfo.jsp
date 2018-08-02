<%@page import="com.pcg.spring.dto.JSPMember"%>
<%@page import="com.pcg.spring.dao.JSPMemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

	<%
	String joinroot=(String)session.getAttribute("joinroot");	
	String id = request.getParameter("id");
			
	%>
	<center>
		<h1>회원정보상세보기</h1>
		<table border="1" width="500" >
			<tr height="50" align="center">
				<td bgcolor="#cccccc">아이디</td>
				<td>${dto.id}</td>
			</tr>
			<tr height="50" align="center">
				<td bgcolor="#cccccc">이메일</td>
				<td>${dto.email}</td>
			</tr>
			<tr height="50" align="center">
				<td bgcolor="#cccccc">전화</td>
				<td>${dto.tel}</td>
			</tr>
			<tr height="50" align="center">
				<td bgcolor="#cccccc">직업</td>
				<td>${dto.job}</td>
			</tr>
			<tr height="50" align="center">
				<td bgcolor="#cccccc">연령대</td>
				<td>${dto.age}</td>
			</tr>
			<tr height="50" align="center">
				<td bgcolor="#cccccc">취미</td>
				<td>${dto.hobby}</td>
			</tr>
			<tr height="50"  bgcolor="lightgreen">
				<td colspan="2" align="center">
					<button onclick="location.href='MemberUpdateForm?id=${dto.id}'">수정하기</button>
					<button onclick="location.href='MemberDeleteForm?id=${dto.id}'">삭제하기</button>
				<button onclick="location.href='MemberJoin'">회원가입</button>
				<button onclick="location.href='MemberList'">목록보기</button>
				</td>
				
			</tr>
			
		</table>
	</center>
</body>
</html>