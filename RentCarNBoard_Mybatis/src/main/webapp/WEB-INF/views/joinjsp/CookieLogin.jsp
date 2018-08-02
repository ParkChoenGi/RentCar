<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<%
		String joinroot = (String) session.getAttribute("joinroot");
		Cookie[] cookies = request.getCookies();
		String id = "";
		for (Cookie x : cookies) {
			if (x.getName().equals("id")) {
				id = x.getValue();
				break;
			}
		}
	%>

	<center>
		<h2>로그인</h2>
		<table width='500' border='1'>
			<tr height='50'>
				<td align='center' colspan='2'>
					<button onclick="location.href='<%=joinroot%>MemberJoin'">회원가입</button>
				</td>
			</tr>
			<form action='<%=joinroot%>CookieLoginProc' method='post'>
				<tr height='50'>
					<td width='150' align='center'>아이디</td>
					<td width='350' align='center'><input type='input' name='id'
						size='40' value="<%=id%>"></td>
				</tr>
			<tr height='50'>
				<td width='150' align='center'>비밀번호</td>
				<td width='350' align='center'><input type='password'
					name='pass' size='40'></td>
			</tr>

			<tr height='50'>
				<td align='center' colspan='2'><input type="checkbox"
					name="cookieSave" value="쿠키저장">쿠키저장&nbsp; <input
					type='submit' value='로그인'></td>
			</tr>
			</form>


		</table>
	</center>

</body>
</html>
</body>
</html>