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
		String id = (String) session.getAttribute("id");
		String root = (String) session.getAttribute("root");
		String joinroot = (String) session.getAttribute("joinroot");
		if (id == null) {
			id = "GUEST";
		}
	%>
	<table width="100%">
		<tr height="70">
			<td align="center" colspan="4"><a href="Main"
				style="text-decoration: none"> <img alt="로고출력자리"
					src="resources/img/LOGO.jpg" height="65">
			</a></td>
			<td align="center" width="200"><%=id%>님 <%
				if (id.equals("GUEST")) {
			%>
				<button onclick="location.href='Login'">로그인</button> <%
 	} else {
 %>
				<button onclick="location.href='Logout'">로그아웃</button> <%
 	}
 %></td>
		</tr>
		<tr height="30">
			<td align="center" width="20%" bgcolor="red"><a
				href="CarReserveMain" style="text-decoration: none"><font
					color="white" size="4">예약하기</font></a></td>
			<td align="center" width="20%" bgcolor="red"><a
				href="ReserveView" style="text-decoration: none"><font
					color="white" size="4">예약확인</font></a></td>
			<td align="center" width="20%" bgcolor="red"><a href="BoardList"
				style="text-decoration: none"><font color="white" size="4">자유게시판</font></a></td>
			<td align="center" width="20%" bgcolor="red"><a href="BatchForm"
				style="text-decoration: none"><font color="white" size="4">차량등록</font></a>
			</td>
			<td align="center" width="20%" bgcolor="red"><a
				href="MemberList" style="text-decoration: none"><font
					color="white" size="4">고객정보</font></a></td>
		</tr>

	</table>
</body>
</html>