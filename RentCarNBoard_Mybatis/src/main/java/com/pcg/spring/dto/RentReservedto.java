package com.pcg.spring.dto;

public class RentReservedto {
	private int regno;// 예약번호
	private int no;// 렌트차량번호
	private int qty;// 대여수량
	private int dday;// 대여기간
	private String rday;// 대여일자
	private int insurance;// 보험적용유무 1.적용 2.비적용
	private int wifi;// 와이파이적용유무 1.적용 2.비적용
	private int navigation; // 네비게이션적용유무 1.적용 2.비적용
	private int babyseat; // 어린아이 시트 대여여부 1.적용 2.비적용
	private String memid; // 예약자(고객) 아이디

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getDday() {
		return dday;
	}

	public void setDday(int dday) {
		this.dday = dday;
	}

	public String getRday() {
		return rday;
	}

	public void setRday(String rday) {
		this.rday = rday;
	}

	public int getInsurance() {
		return insurance;
	}

	public void setInsurance(int insurance) {
		this.insurance = insurance;
	}

	public int getWifi() {
		return wifi;
	}

	public void setWifi(int wifi) {
		this.wifi = wifi;
	}

	public int getNavigation() {
		return navigation;
	}

	public void setNavigation(int navigation) {
		this.navigation = navigation;
	}

	public int getBabyseat() {
		return babyseat;
	}

	public void setBabyseat(int babyseat) {
		this.babyseat = babyseat;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	@Override
	public String toString() {
		return "예약정보[regno=" + regno + ", no=" + no + ", qty=" + qty + ", dday=" + dday + ", rday=" + rday
				+ ", insurance=" + insurance + ", wifi=" + wifi + ", navigation=" + navigation + ", babyseat="
				+ babyseat + ", memid=" + memid + "]";
	}
}
