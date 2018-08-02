package com.pcg.spring.dto;


public class ReserveView {
	private String img;
	private String name;
	private int qty;
	private String rday;
	private int dday;
	private int price;
	private int insurance;
	private int wifi;
	private int navigation;
	private int babyseat;
	private String memid;
	private int regno;
	
	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public String getImg() {
		return img;
	}

	public String getName() {
		return name;
	}

	public int getQty() {
		return qty;
	}

	public String getRday() {
		return rday;
	}

	public int getDday() {
		return dday;
	}

	public int getPrice() {
		return price;
	}

	public int getInsurance() {
		return insurance;
	}

	public int getWifi() {
		return wifi;
	}

	public int getNavigation() {
		return navigation;
	}

	public int getBabyseat() {
		return babyseat;
	}

	public String getMemid() {
		return memid;
	}

	@Override
	public String toString() {
		return "예약정보 [img=" + img + ", name=" + name + ", qty=" + qty + ", rday=" + rday + ", dday=" + dday + ", price="
				+ price + ", insurance=" + insurance + ", wifi=" + wifi + ", navigation=" + navigation + ", babyseat="
				+ babyseat + ", memid=" + memid + "]";
	}

	// 요금정보
	public String getFeeInfo() {
		String feeString = "";
		int a, b;
		feeString += "차량대여료:" + (a = getPrice() * getDday());
		feeString += "/옵션대:" + (b = (insurance * 10000 *dday *qty) + (wifi * 10000 *qty) + (navigation * 0) + (babyseat * 5000 *qty));
		feeString += "  [ 총계: " + (a + b)+" ]";
		return feeString;
	}

	// 예약확인 정보 한 row생성 소스 만들기
	public String getReverseInfoRow(String color) {
		StringBuffer trBuffer = new StringBuffer();
		trBuffer.append("<tr align='center' bgcolor='" + color + "'>");
			int a, b;
			// 예약번호 // 차량이미지// 차종 // 예약일 // 대여일수  // 대여수량 // 보험 // wifi// navi // bbst // 대여금액내역// 수정 // 삭제
			trBuffer.append("<td height='50' width='3%'>");
			trBuffer.append("" + getRegno() + "");
			trBuffer.append("</td>");
			
			trBuffer.append("<td height='50' width='10%'>");
			trBuffer.append("<img width='150' height='70' alt='' src='resources/img/" + getImg() + "' >");
			trBuffer.append("</td>");
			//
			trBuffer.append("<td height='50' width='3%'>");
			trBuffer.append("" + getName() + "");
			trBuffer.append("</td>");
			//
			trBuffer.append("<td height='50' width='10%'>");
			trBuffer.append("" + getRday() + "");
			trBuffer.append("</td>");
			//
			trBuffer.append("<td height='50' width='3%'>");
			trBuffer.append("" + getDday() + "");
			trBuffer.append("</td>");
			
			//
			trBuffer.append("<td height='50' width='3%'>");
			trBuffer.append("" + getQty() + "");
			trBuffer.append("</td>");
			//
			trBuffer.append("<td height='50' width='3%'>");
			trBuffer.append("" + insurance + "");
			trBuffer.append("</td>");
			//
			trBuffer.append("<td height='50' width='3%'>");
			trBuffer.append("" + wifi + "");
			trBuffer.append("</td>");
			//
			trBuffer.append("<td height='50' width='3%'>");
			trBuffer.append("" + navigation + "");
			trBuffer.append("</td>");
			//
			trBuffer.append("<td height='50' width='3%'>");
			trBuffer.append("" + babyseat + "");
			trBuffer.append("</td>");
			//
			trBuffer.append("<td height='50' >");
			trBuffer.append("" + getFeeInfo() + "");
			trBuffer.append("</td>");
			
			//trBuffer.append("</tr>");

		
		return trBuffer.toString();
	}

}