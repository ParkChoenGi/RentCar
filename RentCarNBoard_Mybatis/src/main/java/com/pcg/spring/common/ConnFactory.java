package com.pcg.spring.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConnFactory {
	public static Connection getConnection(String dbConfig){
		ResourceBundle bundle = 
				ResourceBundle.getBundle(dbConfig);
		
		return getConnection(bundle);
	}
	public static Connection getConnection(ResourceBundle bundle){
	
		try {
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
			System.err.println("드라이버가 없습니다.");
			System.exit(0);
		}

		Connection conn = null;
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("url,user,password 점검!");
			System.exit(0);
		}
		return conn;
	}
	
	/**
	 * 미리 준비할 부분  - 톰켓서버의 server.xml 컨텍스트 테그부분에 다음과 같이 준비가 <br>
	 * 되어있어야 한다. 
	 * &lt;Context docBase="JSP02_MemberJoin" path="/JSP02_MemberJoin"
					reloadable="true" source="org.eclipse.jst.jee.server:JSP02_MemberJoin" &gt;
					
					&lt;Resource name="jdbc/pool" auth="Container"	type="javax.sql.DataSource"
					driverClassName="oracle.jdbc.driver.OracleDriver"
					loginTimeout="10" maxWait="5000" username="sem" password="java"
					url="jdbc:oracle:thin:@localhost:1521:xe"/&gt;
					
			&lt;/Context&gt;
	 * 
	 * @return Connection객체를 DCP에서 꺼집어 내어 리턴시켜준다. 
	 */
	
	public static Connection getConnectionByDCP(){
		
		/* 미리 server.xml의 해당프로젝트 컨텍스트 테그부분에 아래와 같은 내용을 실정에 맞게 준비해야 한다.
		 * 
		 * 
					
					<Resource name="jdbc/pool" auth="Container"	type="javax.sql.DataSource"
					driverClassName="oracle.jdbc.driver.OracleDriver"
					loginTimeout="10" maxWait="5000" username="sem" password="java"
					url="jdbc:oracle:thin:@localhost:1521:xe"/>
		
		 * 
		 * 
		 * 
		 */
		
		
		
		Connection conn =null;
		try {
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
}








