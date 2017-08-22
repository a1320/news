package com.gdglc.news.action;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/**
 * 
 * 系统初始化servlet，项目启动的时候自动加载一些系统参数
 * 
 *
 * @author allan
 * @version $Date: 2017年8月22日 $
 */
public class InitAction extends HttpServlet{

	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		String path = servletContext.getContextPath();
		System.out.println(path);
		servletContext.setAttribute("path", path);
		String contextLocation = servletContext.getInitParameter("location");
		System.out.println("contextLocation="+contextLocation);
		ServletConfig servletConfig = getServletConfig();
		String configLocation =servletConfig.getInitParameter("location");
		System.out.println("configLocation="+configLocation);
	}
	
}
