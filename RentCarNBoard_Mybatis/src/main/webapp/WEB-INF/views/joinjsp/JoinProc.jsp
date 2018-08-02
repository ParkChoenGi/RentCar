<%@page import="java.sql.SQLException"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입처리</title>
</head>
<body>

	<%
		int res = (int) request.getAttribute("res");

		if (res == 1) {
	%>
	<script>
		location.href = 'MemberList';
	</script>
	<%
		} else {
	%>
	<script>
		alert("기입이 안되어있습니다.")
		history.go(-1);
	</script>


	<%
		}
	%>


</body>
</html>