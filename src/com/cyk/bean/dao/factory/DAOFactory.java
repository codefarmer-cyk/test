package com.cyk.bean.dao.factory;

import com.cyk.bean.dao.UserDAO;
import com.cyk.bean.dao.proxy.UserDAOProxy;

public class DAOFactory {
	public UserDAO getUserDAOInstance(){
		return new UserDAOProxy();
	}
}
