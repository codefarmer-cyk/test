package com.cyk.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyk.bean.dao.factory.DAOFactory;
import com.cyk.bean.vo.User;

public class RegistServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegistServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag = false;
		String path = "success.jsp";
		List<String> info = new ArrayList();
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		User user = new User();
		user.setUserid(userid);
		user.setPassword(password);
		DAOFactory factory = new DAOFactory();
		try {
			flag = factory.getUserDAOInstance().Regist(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag) {
			request.setAttribute("userid", userid);
			info.add("注册成功！");
		} else
			info.add("注册失败！");
		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
		response.getWriter().print(flag);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
