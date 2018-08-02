package com.pcg.spring.common;

import com.pcg.spring.dto.RentReservedto;
import com.sung.jdbc.dbtools.DBTableGenerator;

public class RentCarDBTabeGen {

	public static void main(String[] args) {
		//DBTableGenerator.generateDBTable(RentCar.class, "oracle");
		//System.out.println("테이블생성완료");
		DBTableGenerator.dbGenerate("oracle", new Class[]{RentReservedto.class}, true); 
	}

}
