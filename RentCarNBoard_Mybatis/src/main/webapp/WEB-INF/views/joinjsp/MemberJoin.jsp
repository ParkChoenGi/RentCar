<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script type="text/javascript">
	function email_change() {
		if (document.join.email.options[document.join.email.selectedIndex].value == '0') {
			document.join.email2.disabled = true;
			document.join.email2.value = "";
		}
		if (document.join.email.options[document.join.email.selectedIndex].value == 'DirectInput') {
			document.join.email2.disabled = false;
			document.join.email2.value = "";
			document.join.email2.focus();
		} else {
			document.join.email2.disabled = true;
			document.join.email2.value = document.join.email.options[document.join.email.selectedIndex].value;
		}
	}
</script>
<style>
.divForm {
	width: 800px;
}
</style>
</head>
<body>
	<%
		String joinroot = (String) session.getAttribute("joinroot");
	%>
	<center>
		<h2>회원가입</h2>
		<div class="divForm">
			<form name="join" action='JoinProc' method='post'>
				<table width='800' class="table table-striped">
					<tr height='30'>
						<td width='150' align='center' bgcolor="#cccccc">아이디</td>
						<td width='550' align='left'><input type='input' name='id'
							size='40'></td>
					</tr>
					<tr height='30'>
						<td width='150' align='center' bgcolor="#cccccc">비밀번호</td>
						<td width='550' align='left'><input type='password'
							name='pass' size='40'></td>
					</tr>
					<tr height='30'>
						<td width='150' align='center' bgcolor="#cccccc">비밀번호확인</td>
						<td width='550' align='left'><input type='password'
							name='pass' size='40'></td>
					</tr>
					<tr height='30'>
						<td width='150' align='center' bgcolor="#cccccc">생년월일</td>
						<td><select name="year">
								<option value="2000">2000</option>
								<option value="1999">1999</option>
								<option value="1998">1998</option>
								<option value="1997">1997</option>
								<option value="1996">1996</option>
								<option value="1995">1995</option>
								<option value="1994">1994</option>
								<option value="1993">1993</option>
								<option value="1992">1992</option>
								<option value="1991">1991</option>
								<option value="1990">1990</option>
								<option value="1989">1989</option>
								<option value="1988">1988</option>
								<option value="1987">1987</option>
								<option value="1986">1986</option>
								<option value="1985">1985</option>
								<option value="1984">1984</option>
								<option value="1983">1983</option>
								<option value="1982">1982</option>
								<option value="1981">1981</option>
								<option value="1980">1980</option>
								<option value="1979">1979</option>
								<option value="1978">1978</option>
								<option value="1977">1977</option>
								<option value="1976">1976</option>
								<option value="1975">1975</option>
								<option value="year" selected="selected">year</option>
						</select> <select name="month">
								<option value="1월">1월</option>
								<option value="2월">2월</option>
								<option value="3월">3월</option>
								<option value="4월">4월</option>
								<option value="5월">5월</option>
								<option value="6월">6월</option>
								<option value="7월">7월</option>
								<option value="8월">8월</option>
								<option value="9월">9월</option>
								<option value="10월">10월</option>
								<option value="11월">11월</option>
								<option value="12월">12월</option>
								<option value="month" selected="selected">month</option>
						</select> <select name="day">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="28">28</option>
								<option value="29">29</option>
								<option value="30">30</option>
								<option value="31">31</option>
								<option value="day" selected="selected">day</option>
						</select></td>
					</tr>
					<tr height='30'>
						<td width='150' align='center'>이메일</td>
						<td width='400' align='left'><input type='text' name="email1"
							size='20'> @ <input type="text" name="email2" value=""
							disabled> <select name="email" onchange="email_change()">
								<option value="0" selected="selected">선택하세요</option>
								<option value="DirectInput">직접입력</option>
								<option value="naver.com">naver.com</option>
								<option value="daum.net">daum.net</option>
								<option value="nate.com">nate.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="yahoo.co.kr">yahoo.co.kr</option>
								<option value="vision.com">vision.com</option>
						</select></td>
					</tr>
					<tr height='30'>
						<td width='150' align='center' bgcolor="#cccccc">주소</td>
						<td width='550' align='left'><input type='text'
							name='address' size='40'></td>
					</tr>
					<tr height='30'>
						<td width='150' align='center' bgcolor="#cccccc">전화번호</td>
						<td width='550' align='left'><input type='tel' name='tel'
							size='40'></td>
					</tr>
					<tr height='30'>
						<td align='center' colspan='2'><input type='submit'
							value='가입하기'> <input type="reset" value='삭제하기'></td>


						</td>
					</tr>



				</table>
			</form>
		</div>
	</center>
</body>
</html>