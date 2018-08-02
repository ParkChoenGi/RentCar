package com.pcg.spring.dao;


import java.util.ArrayList;

import com.pcg.spring.dto.RentReservedto;
import com.pcg.spring.dto.ReserveView;



public interface ReserveDao {
	public ArrayList<RentReservedto> selectAll();

	public RentReservedto selectRegNo(int Regno);

	public ArrayList<RentReservedto> selectRday(int rday);

	public ArrayList<RentReservedto> selectId(String memid);

	public void insert(int no, int qty, int dday, String rday, int insurance, int wifi, int navigation,
			int babyseat, String memid);

	public void delete(int regno);

	public void update(int no, String rday, int dday, int qty, int insurance, int wifi, int navigation, int babyseat,
			String memid ,int regno);
	
	public ArrayList<ReserveView> selectAllView (String memid);
	
}
