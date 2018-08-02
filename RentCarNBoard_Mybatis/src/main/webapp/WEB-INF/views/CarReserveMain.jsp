<%@page import="java.sql.SQLException"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
<center>
	<!-- 데이타베이스에서 최신순 3대만 가져오기 -->
	
	<table width="1000">
		<tr>
			<td align="center" colspan="3">
				<font size="6" color="gray">최신등록차량</font>
			</td>
		</tr>
		<tr height="240">
			<c:forEach items="${list}" var="rentcar"> 
			<td width="333" align="center">
				<a href="CarReserveInfo?no=${rentcar.no}">
					<img alt=""	src="resources/img/${rentcar.img}" width="300" height="200">
				</a>
				<p>차량명 : ${rentcar.name}</td>
			</c:forEach>

		</tr>
</table>
<hr color="red" size="3">
<p>	
	<font size="4" color="gray" >차량 검색 하기</font><br><br><br>
	<form action="CarCategoryList" method="post">
	
	
		<font size="3" color="gray"><b>차량검색하기</b></font>&nbsp;&nbsp;
		<select name = "category" style="">
			<option value="1">소형</option>
			<option value="2">중형</option> 
			<option value="3">대형</option>  
		</select>&nbsp;&nbsp;
		<input type="submit" value="검색">&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="location.href='CarAllList'">전체검색</button>
	</form>
	
	
</center>
</body>
</html>