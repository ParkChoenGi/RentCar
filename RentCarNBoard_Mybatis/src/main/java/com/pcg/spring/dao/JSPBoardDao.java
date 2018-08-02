
package com.pcg.spring.dao;

import java.util.ArrayList;

import com.pcg.spring.dto.JSPBoard;

public interface JSPBoardDao {
	
	public void insert(String writer, String email, String subject, String password, String content);

	public void delete(int num);

	public void update(String subject, String content, int num);

	public void upHit(int num);
	
	public JSPBoard select(int num);

	public ArrayList<JSPBoard> selectAll();

	public void insert2(String writer, String email, String subject, String password, int ref, int re_step,
			int re_level, String content);

	public void updateLevel(int ref, int re_level);
	
}

//// private int num;
// private String writer;
// private String email;
// private String subject;
// private String password;
// private String reg_date;
// private int ref;
// private int re_step;
// private int re_level;
// private int readcount;
// private String content;
