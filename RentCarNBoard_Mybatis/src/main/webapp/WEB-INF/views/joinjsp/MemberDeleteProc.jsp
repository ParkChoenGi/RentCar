<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>저장하기</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		String joinroot = (String) session.getAttribute("joinroot");
	%>

	<%
		int res = (int)request.getAttribute("res");
	if(res == 0) {
	%>

	<script>
		alert('패스워드가 틀렸습니다. 다시입력하세요.');
		history.go(-1);
	</script>


	<%
		} else {
				
	%>
	<script>
				location.href='MemberList';
	</script>
	<%
		}

		
	%>

</body>
</html>