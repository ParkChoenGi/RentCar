<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css" />
<title>보드리스트</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		String root = (String) session.getAttribute("root");
		int currentPage = (int) request.getAttribute("currentPage");
		int currentBlock = (int) request.getAttribute("currentBlock");
		// 수정,댓글, 삭제 후 현재위치로 돌아오게 하기 위해 현 위치값을 세션에 저장
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("currentBlock", currentBlock);
	%>
	<center>

		<h2>전체글보기(${currentPage}/${pageCount})</h2>
		<div style="width: 80%;">
			<table class="table table-striped">

				<tr height="40" align="center" style="font-size: 80%;">
					<td colspan="5" align="left">
						<button onclick="location.href='BoardWriteForm'">글쓰기</button>
					</td>
				</tr>
				<tr height="2">
					<td colspan="5"></td>
				</tr>
				<tr style="font-size: 80%;" align="center">
					<td width="50" style="color: blue;">번호</td>
					<td width="350" style="color: blue;">제목</td>
					<td width="100" style="color: blue;">작성자</td>
					<td width="150" style="color: blue;">날짜</td>
					<td width="50" style="color: blue;">조회수</td>
				</tr>
				<tr height="2">
					<td colspan="5"></td>
				</tr>
				<c:forEach items="${list}" var="dto" varStatus="status">
					<tr>
						<td align="center">${(number - status.index) - ((currentPage - 1) * displayNum)}</td>
						<td><c:forEach begin="1" end="${dto.re_step - 1}">[re]</c:forEach>
							<a href="BoardInfo?num=${dto.num}" style="text-decoration: none">${dto.subject}</a></td>
						<td>${dto.writer}</td>
						<td>${dto.reg_date}</td>
						<td align="center">${dto.readcount}</td>
					</tr>
				</c:forEach>
				<tr height="2">
					<td colspan="5"></td>
				</tr>

			</table>
		</div>
		<p>${pagenation}</p>
	</center>

</body>
</html>