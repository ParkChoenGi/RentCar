<%@page import="com.pcg.spring.dao.JSPBoardDao"%>
<%@page import="com.pcg.spring.dto.JSPBoard"%>
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
	<center>
		<h2>게시글보기</h2>
		<table width="600">
			<tr height="40">
				<td align="center" width="120" bgcolor="skyblue">글번호</td>
				<td align="center" width="180">${dto.num}</td>
				<td align="center" width="120" bgcolor="skyblue">조회수</td>
				<td align="center" width="180">${dto.readcount}</td>
			</tr>
			<tr height="40">
				<td align="center" width="120" bgcolor="skyblue">작성자</td>
				<td align="center" width="180">${dto.writer}</td>
				<td align="center" width="120" bgcolor="skyblue">작성일</td>
				<td align="center" width="180">${dto.reg_date}</td>
			</tr>
			<tr height="40">
				<td align="center" width="120" bgcolor="skyblue">제목</td>
				<td align="center" colspan="3">${dto.subject}</td>
			</tr>
			<tr height="40">
				<td align="center" width="120" bgcolor="skyblue">글내용</td>
				<td align="center" colspan="3">${dto.content}</td>
			</tr>
			<tr height="40">
				<td align="center" colspan="4"><input type="button"
					value="답글쓰기"
					onclick="location.href='BoardReWriteForm?num=${dto.num}'">
					<input type="button" value="수정하기"
					onclick="location.href='BoardUpdateForm?num=${dto.num}'">
					 <input	type="button" value="삭제하기"
					onclick="location.href='BoardDeleteForm?num=${dto.num}'">
					<%
						int backPage = Integer.parseInt(session.getAttribute("currentPage") + "");
						int backBlock = Integer.parseInt(session.getAttribute("currentBlock") + "");
					%> <input type="button" value="목록보기"
					onclick="location.href='BoardList?pageNum=<%=backPage%>&pageBlock=<%=backBlock%>'"></td>
			</tr>


		</table>
	</center>
</body>
</html>