package com.cyk.bean.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cyk.bean.dao.UserDAO;
import com.cyk.bean.vo.User;

public class UserDAOImpl implements UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public UserDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean Login(User user) throws Exception {
		// TODO Auto-generated method stu
		boolean flag = false;
		String sql = "select userid from login_info where userid =? and password = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getUserid());
		this.pstmt.setString(2, user.getPassword());
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			flag = true;
		}
		if (this.pstmt == null) {
			this.pstmt.close();
		}
		return flag;
	}

	@Override
	public boolean CheckUserid(String userid) throws SQLException {
		boolean flag = false;
		String sql = "select userid from login_info where userid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, userid);
		ResultSet rs = this.pstmt.executeQuery();
		System.out.println("wtf");
		if (rs.next()) {
			flag = true;
		}
		if (this.pstmt == null) {
			this.pstmt.close();
		}
		return flag;
	}

	@Override
	public boolean Regist(User user) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		String userid = user.getUserid();
		String password = user.getPassword();
		String sql = "insert into login_info values(?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, userid);
		this.pstmt.setString(2, password);
		flag = this.pstmt.execute();
		return flag;
	}

}
