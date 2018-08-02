<%@page import="java.sql.SQLException"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답글쓰기</title>
</head>
<body>
	
	<center>
		<h2>답변글 입력하기</h2>
		<form action="BoardReWriteProc" method="post">
			<table width="600">
				<tr height="40">
					<td width="150" align="center" size="60" bgcolor="lightgreen">작성자</td>
					<td width="450"><input type="text" name="writer" size="60"></td>

				</tr>
				<tr height="40">
					<td width="150" align="center" size="60" bgcolor="lightgreen">제목</td>
					<td width="450"><input type="text" name="subject" value="[답변]"
						size="60"></td>
				</tr>

				<tr height="40">
					<td width="150" align="center" size="60" bgcolor="lightgreen">이메일</td>
					<td width="450"><input type="text" name="email" size="60"></td>
				</tr>

				<tr height="40">
					<td width="150" align="center" size="60" bgcolor="lightgreen">비밀번호</td>
					<td width="450"><input type="password" name="password"
						size="60"></td>
				</tr>
				<tr height="40">
					<td width="150" align="center" size="60" bgcolor="lightgreen">글내용</td>
					<td width="450"><textarea name="content" rows=10 cols="60"></textarea></td>
				</tr>
				<tr height="40">
					<!-- 답변글임을 디비에 알려야 한다. 폼으로부터 입력받지 않고 데이터를 넘기기 -->
					<input type="hidden" name="ref" value="${dto.ref}">
					<input type="hidden" name="re_step" value="${dto.re_step}">
					<input type="hidden" name="re_level" value="${dto.re_level}">
					<td colspan="2" align="center" border="1"><input type="submit"
						value="답글입력"> &nbsp; &nbsp; <input type="reset"
						value="취소하기"> &nbsp; &nbsp; <input type="button"
						onclick="location.href='BoardList'" value="모두보기">
						&nbsp; &nbsp;</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>