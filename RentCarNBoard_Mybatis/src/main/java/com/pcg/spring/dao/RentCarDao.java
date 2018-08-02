
package com.pcg.spring.dao;


import java.util.ArrayList;

import com.pcg.spring.dto.RentCarBDto;


public interface RentCarDao {
	
	public void insert(int no , String name , int category , int price , int usepeople , String company , String img , String info );
	public void delete(String no);
	public void update(String name, int category,int price,int usepeople,String company,String img,String info,String no);
	
	public ArrayList<RentCarBDto> selectAll();
	
	public RentCarBDto selectNo(int no);
	
	public ArrayList<RentCarBDto> selectCategory(int category);
}
