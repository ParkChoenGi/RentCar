<%@page import="com.pcg.spring.dto.RentCarBDto"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String joinroot = (String) session.getAttribute("joinroot");
     int currentPage =  (int)request.getAttribute("currentPage");
	 int currentBlock = (int)request.getAttribute("currentBlock");
	// 수정,댓글, 삭제 후 현재위치로 돌아오게 하기 위해 현 위치값을 세션에 저장
	session.setAttribute("currentPage", currentPage);
	session.setAttribute("currentBlock", currentBlock);
	List<RentCarBDto> list = (List<RentCarBDto>)request.getAttribute("list");
	System.out.println(list);
	
	%>
	<center>
		<table>
			<tr>
				<td align="center" colspan="3"><font size="6" color="gray">전체렌트카보기(${currentPage}/${pageCount})</font>
				</td>
			</tr>
			<%
				int j = 0;
				for (int i = 0; i < list.size(); i++) {
					RentCarBDto dto = list.get(i);
					if (i % 3 == 0) {
			%><tr height="220">
				<%
					}
				%>

				<td width="33%" align="center"><a
					href="Main?center=CarReserveInfo?no=<%=dto.getNo() %>&fromPage=CarAllList">
						<img alt="" src="resources/img/<%=dto.getImg() %>" width="300" height="200">
				</a>
					<p>
						<font size="3" color="gray"><b>차량명 : <%=dto.getName() %></b></font></td>
				<%
					j += 1;

					}
				%>
			
		</table>
		<p>
		${pagenation}
		</p>
	</center>


</body>
</html>