package com.cyk.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyk.bean.dao.factory.DAOFactory;
import com.cyk.bean.vo.User;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "success.jsp";
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		List<String> info = new ArrayList();
		if (userid == null || "".equals(userid)) {
			info.add("用户id不能为空！");
		}
		if (password == null || "".equals(password)) {
			info.add("密码不能为空！");
		}
		if (info.size() == 0) {
			User user = new User();
			user.setUserid(userid);
			user.setPassword(password);
			DAOFactory factory = new DAOFactory();
			try {
				if (factory.getUserDAOInstance().Login(user)) {
					info.add("用户登录成功，欢迎" + user.getUserid() + "光临！");
				} else {
					info.add("用户登录失败，用户id或密码错误");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("info", info);
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
