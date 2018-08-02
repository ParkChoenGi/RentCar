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
		if (res == 1) {
			out.print("잘 저장되었습니다.");
			int backPage = Integer.parseInt(session.getAttribute("currentPage") + "");
			int backBlock = Integer.parseInt(session.getAttribute("currentBlock") + "");
			//response.sendRedirect(root+"BoardList.jsp?pageNum="+backPage+"&pageBlock="+backBlock+"");
	%><script>
		location.href='BoardList?pageNum=<%=backPage%>&pageBlock=<%=backBlock%>';
	</script>
	<%
		}
	%>

</body>
</html>