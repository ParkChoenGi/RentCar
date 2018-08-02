package com.pcg.spring.common;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormMaker {
	enum Keys{
		INPUT,SELECT,RADIO,CHECK
	}
	public String title;
	public static List<Inputs> inputList;
	public static List<Radios> radioList;
	public static List<Selects> selectList;
	public static List<Checks> checkList;
	public static Map<Keys,List> listMap;

	static class Inputs {
		String type;
		String caption;
		String name;
		int size;

		public Inputs(String type, String caption, String name, int size) {
			super();
			this.type = type;
			this.caption = caption;
			this.name = name;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Inputs [type=" + type + ", caption=" + caption + ", name=" + name + ", size=" + size + "]";
		}

	}

	static class Radios {
		String name;
		String value;
		String caption;
		public Radios(String name, String value, String caption) {
			super();
			this.name = name;
			this.value = value;
			this.caption = caption;
		}
		@Override
		public String toString() {
			return "Radios [name=" + name + ", value=" + value + ", caption=" + caption + "]";
		}
		
	}

	static class Selects {
		String name;
		String value;
		String caption;
		
		public Selects(String name, String value, String caption) {
			super();
			this.name = name;
			this.value = value;
			this.caption = caption;
		}

		@Override
		public String toString() {
			return "Selects [name=" + name + ", value=" + value + ", caption=" + caption + "]";
		}
		
	}

	static class Checks {
		//name,value,caption
		String name;
		String value;
		String caption;
		public Checks(String name, String value, String caption) {
			super();
			this.name = name;
			this.value = value;
			this.caption = caption;
		}
		@Override
		public String toString() {
			return "Checks [name=" + name + ", value=" + value + ", caption=" + caption + "]";
		}
		
	}

	public FormMaker(String title, Map<Keys,List> listMap) {
		this.listMap =listMap; 
		this.title = title;
		inputList = listMap.get(Keys.INPUT);
		radioList = listMap.get(Keys.RADIO);
		selectList = listMap.get(Keys.SELECT);
		checkList = listMap.get(Keys.CHECK);
	}

	public String getHTML() {
		StringBuffer b = new StringBuffer();
		b.append("<html><head><title>"+ title+ "</title></head>\n");
		b.append("<body>\n");
		b.append("<h1>회원등록</h1>\n");
		b.append("<center>\n"
				+"<h2>등록하기</h2>\n"
				+"<form action='JoinProc.jsp' method='post'>\n"
				+"<table width='500' border='1'>\n");
			
		if (inputList != null) {
			for (Inputs x : inputList) {
				
				b.append("<tr height='50'>\n");
				b.append("<td width='150' align='center'>"+x.caption+"</td>\n");
				b.append("<td width='350' align='center'><input type='"+x.type+"' ");
				b.append("name='"+x.name+"' ");
				b.append("size='"+x.size+"'>\n</td>\n</tr>\n");
			}
		}
		if (radioList != null) {
			
			b.append("<tr height='50'>\n");
			b.append("<td width='150' align='center'>");
			b.append("?라디오버튼</td>");
			b.append("<td width='350' align='center'>\n");
			for (Radios x : radioList) {
				b.append("<input type='radio' name='"+x.name+"' value = '"+x.value+"'>"+x.caption+"&nbsp;&nbsp;\n");
			}
			b.append("</td> </tr>\n");		
		}
		if (selectList != null) {
			b.append("<tr height='50'>\n");
			b.append("<td width='150' align='center'>");
			b.append("콤보박스</td>\n");
			b.append("<td width='350' align='center'>\n");
			String name = selectList.get(0).name;
			b.append("<select name='"+name+"'>\n");
			for (Selects x : selectList) {
				b.append("<option value='"+x.value+"' >"+x.caption+"</option>\n");
			}
			b.append("</select> </tr>\n");		
		}
		if (checkList != null) {
			b.append("<tr height='50'>\n");
			b.append("<td width='150' align='center'>");
			b.append("체크박스</td>");
			b.append("<td width='350' align='center'>\n");
			for (Radios x : radioList) {
				b.append("<input type='checkbox' name='"+x.name+"' value = '"+x.value+"'>"+x.caption+"&nbsp;&nbsp;\n");
			}
			b.append("</td> </tr>\n");		
		}
		
		
		b.append("<tr height='50'>\n"
				+"<td align='center' colspan='2'>\n"
				+"<input type ='submit' value='가입'>\n"
				+"</td>\n"
				+"</tr>\n"
				+"</table>\n"
				+"</form> </center>\n");

		b.append("<hr><address>"+"아무개"+"</address>");
		b.append("</body></html>\n");
		
		return b.toString();
	}

	
}