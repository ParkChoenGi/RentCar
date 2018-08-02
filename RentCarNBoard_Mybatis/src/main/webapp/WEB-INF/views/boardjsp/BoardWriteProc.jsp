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
		request.setCharacterEncoding("utf-8");
		String root = (String) session.getAttribute("root");
		int res = (int) request.getAttribute("res");

		if (res == 1) {
			out.print("잘 저장되었습니다.");
	%><script>
		location.href='BoardList';
	</script>
	<%
		} else {
	%>
	<script>
		alert('빈 공란을 둘 수 없습니다.')
		history.go(-1);
	</script>
	<%
		}
	%>

</body>
</html>