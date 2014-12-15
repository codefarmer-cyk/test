package com.cyk.bean.dao.proxy;

import java.sql.SQLException;

import com.cyk.bean.dao.UserDAO;
import com.cyk.bean.dao.dbc.DatabaseConnection;
import com.cyk.bean.dao.impl.UserDAOImpl;
import com.cyk.bean.vo.User;

public class UserDAOProxy implements UserDAO {
	private DatabaseConnection dbc;
	private UserDAO dao;

	public UserDAOProxy() {
		try {
			this.dbc = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dao = new UserDAOImpl(this.dbc.getConnection());
	}

	@Override
	public boolean Login(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = this.dao.Login(user);
		this.dbc.close();
		return flag;
	}

	@Override
	public boolean CheckUserid(String userid) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = this.dao.CheckUserid(userid);
		return flag;
	}

	@Override
	public boolean Regist(User user) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = this.dao.Regist(user);
		return flag;
	}

}
