package com.cyk.bean.dao;

import java.sql.SQLException;

import com.cyk.bean.vo.User;

public interface UserDAO {
	public boolean Login(User user) throws Exception;
	public boolean CheckUserid(String userid) throws SQLException;
	public boolean Regist(User user) throws SQLException;
}
