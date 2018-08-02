<%@page import="com.pcg.spring.dao.RentCarDao"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.SQLException"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int res = (int) request.getAttribute("res");
		String id = (String) request.getAttribute("id");
		if (res == 1) {
			session.setAttribute("id", id);
	%>
	<script>
		location.href = "CarReserveMain";
	</script>
	<%
		} else {
	%>
	<script>
		alert("회원아이디 혹은 패스워드가 틀립니다.");
		location.href = "Login";
	</script>
	<%
		}
	%>
</body>
</html>