package com.cyk.bean.dao.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/login_test";
	private static final String DBUSER = "cyk";
	private static final String DBPASSWORD="123456";
	private Connection conn = null;
	public DatabaseConnection() throws Exception {
		Class.forName(DBDRIVER);
		this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
	}
	public Connection getConnection() {
		return conn;
	}
	
	public void close(){
		if(this.conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
