

<%@page import="com.pcg.spring.dao.ReserveDao"%>
<%@page import="com.pcg.spring.dao.RentCarDao"%>
<%@page import="com.pcg.spring.dto.RentReservedto"%>
<%@page import="com.pcg.spring.dto.RentCarBDto"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	request.setCharacterEncoding("utf-8");

	RentCarDao rdao = (RentCarDao) request.getAttribute("rdao");
	ReserveDao dao = (ReserveDao) request.getAttribute("dao");
	String id = (String) session.getAttribute("id");
	if (id == null) {
%>
<script>
	alert('로그인후 예약 가능합니다.');
	location.href = "Login";
</script>
<%
	}

	RentReservedto rbean = (RentReservedto) request.getAttribute("rbean");
	RentCarBDto rentCar = null;
	String option = "";
	int optionFee = 0;
	int rentalFee = 0;
	try {

		//vo = (RentCarBDto)request.getAttribute("dto");

		rentCar = (RentCarBDto) request.getAttribute("rentCar");

		rentalFee = rbean.getDday() * rentCar.getPrice() * rbean.getQty();

		if (rbean.getInsurance() == 1) {
			option += "보험료:" + (rbean.getDday() * 10000) * rbean.getQty();
			optionFee += rbean.getDday() * 10000 * rbean.getQty();
		} else {
			option += "보험료:" + (0);
		}

		if (rbean.getWifi() == 1) {
			option += " 와이파이:" + (10000 * rbean.getQty());
			optionFee += 10000 * rbean.getQty();
		} else {
			option += " 와이파이:" + (0);
		}

		if (rbean.getWifi() == 1) {
			option += " 네이게이션:" + "무료";
		} else {
			option += " 네이게이션:" + "미적용";
		}

		if (rbean.getWifi() == 1) {
			option += " 베이비시트:" + (5000 * rbean.getQty());
			optionFee += 5000 * rbean.getQty();
		} else {
			option += " 베이비시트:" + "미적용";
		}

		Date d1 = new Date();
		Date d2 = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		d1 = sdf.parse(rbean.getRday());
		d2 = sdf.parse(sdf.format(d2));

		int res = d1.compareTo(d2);// -1,0,1
		if (res == -1) {
%>
<script>
	alert("현재 이전 날짜는 예약일로 사용할 수 없습니다.");
	history.go(-1);
</script>
<%
	}
		// 중요함. 빼먹지 말것 
		rbean.setMemid(id);
		dao.insert(rbean.getNo(), rbean.getQty(), rbean.getDday(), rbean.getRday(), rbean.getInsurance(),
				rbean.getWifi(), rbean.getNavigation(), rbean.getBabyseat(), rbean.getMemid());
		int num = dao.selectAll().size();
		RentReservedto dto = dao.selectAll().get(num - 1);
		int reg = dto.getRegno();
		rbean.setRegno(reg);

	} catch (Exception e) {
		e.printStackTrace();
	}
%>

</head>
<body>
	<center>
		<table width=70%>
			<tr bgcolor="lightgreen">
				<td colspan="3" align="center"><font size="5" color="gray">예약결과</font></td>
			</tr>
			<tr>
				<td rowspan="7"><img alt=""
					src="resources/img/<%=rentCar.getImg()%>" /></td>
				<td width="30%">차종</td>
				<td width="40%"><%=rentCar.getName()%></td>
			</tr>
			<tr>
				<td width="30%">대여일자</td>
				<td width="40%"><%=rbean.getRday()%>부터</td>
			</tr>
			<tr>
				<td width="30%">대여일수</td>
				<td width="40%"><%=rbean.getDday()%>일</td>
			</tr>
			<tr>
				<td width="30%">대여수량</td>
				<td width="40%"><%=rbean.getQty()%>대</td>
			</tr>
			<tr>
				<td width="30%">대여금액</td>
				<td width="40%"><%=rentalFee%>원</td>
			</tr>
			<tr>
				<td width="30%">옵션금액</td>
				<td width="40%"><%=optionFee%>원</td>
			</tr>
			<tr>
				<td width="30%">옵션내역</td>
				<td width="40%"><%=option%></td>
			</tr>
			<tr bgcolor="lightgray">
				<td colspan="3" align="center"><font size="4" color="gray">합계액:<%=optionFee + rentalFee%>원
				</font></td>
			</tr>
			<tr bgcolor="lightgray">
				<td colspan="3" align="left"><font size="2" color="gray"><%=rbean.toString()%></font></td>
			</tr>
			<tr bgcolor="lightgray">
				<td colspan="3" align="left"><font size="2" color="gray"><%=rentCar.toString()%></font></td>
			</tr>
		</table>
	</center>
</html>