package com.pcg.spring.common;

import com.pcg.spring.dto.RentCarBDto;
import com.sung.jdbc.dbtools.DBTableGenerator;


public class CreateTable {

	public static void main(String[] args) {
		DBTableGenerator.dbGenerate("oracle",new Class[]{ RentCarBDto.class}, true);

	}

}
