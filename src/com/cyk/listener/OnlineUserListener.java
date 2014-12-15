package com.cyk.listener;

import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserListener implements HttpSessionAttributeListener,
		HttpSessionListener, ServletContextListener {
	private ServletContext app = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		this.app = arg0.getServletContext();
		this.app.setAttribute("online", new TreeSet());
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		Set all = (Set) this.app.getAttribute("online");
		all.remove(arg0.getSession().getAttribute("userid"));
		this.app.setAttribute("online", all);
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		Set all = (Set) this.app.getAttribute("online");
		all.add(arg0.getValue());
		this.app.setAttribute("online", all);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		Set all = (Set) this.app.getAttribute("online");
		all.remove(arg0.getValue());
		this.app.setAttribute("online", all);
		;
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

}
