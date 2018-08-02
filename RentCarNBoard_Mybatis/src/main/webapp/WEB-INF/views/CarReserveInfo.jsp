<%@page import="com.pcg.spring.dto.RentCarBDto"%>
<%@page import="java.sql.SQLException"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%
		int carNo = Integer.parseInt(request.getParameter("no"));
		String fromPage = request.getParameter("fromPage");
		String temp = request.getParameter("category");
		int category = Integer.parseInt((temp != null) ? temp : "0");

		RentCarBDto vo = null;
		String section = "";
		try {

			vo = (RentCarBDto)request.getAttribute("dto");
			section = (category == 1) ? "소형" : (category == 2) ? "중형" : "대형";
		} catch (Exception e) {
			e.printStackTrace();
		}
		//out.println(vo+"<br>");
	%>
	<center>

		<form action="CarOptionSelect" method="post">
			<table width="100%">
				<tr height="100">
					<td align="center" colspan="3"><font size="6" color="gray"><%=vo.getName()%>차량
							선택</font></td>
				</tr>
				<tr>
					<td rowspan="6" width="50%" align="center"><image alt=""
							src="resources/img/<%=vo.getImg()%>" width="450"></image></td>
					<td width="25%" align="center">차량이름</td>
					<td width="25%" align="center"><%=vo.getName()%></td>

				</tr>
				<tr>
					<td width="25%" align="center">대여수량</td>
					<td width="25%" align="center"><select name="qty">
							<option value="1">1대</option>
							<option value="2">2대</option>
							<option value="3">3대</option>
							<option value="4">4대</option>
							<option value="5">5대</option>
					</select></td>
				</tr>
				<tr>
					<td width="25%" align="center">차량분류</td>
					<td width="25%" align="center"><%=section%></td>
				</tr>
				<tr>
					<td width="25%" align="center">대여가격</td>
					<td width="25%" align="center"><%=vo.getPrice()%></td>
				</tr>
				<tr>
					<td width="25%" align="center">제조회사</td>
					<td width="25%" align="center"><%=vo.getCompany()%></td>
				</tr>
				<tr>
					<input type="hidden" name="no" value="<%=vo.getNo()%>">
					<input type="hidden" name="img" value="<%=vo.getImg()%>">
					<td colspan="2" width="50%" align="center"><input
						type="submit" value="옵션선택후구매하기"></td>
				</tr>

			</table>
		</form>

		<p>
			<font size="5" color="gray">차량정보보기</font>
		<p>
			<%=vo.getInfo()%>
	</center>
</body>

</html>