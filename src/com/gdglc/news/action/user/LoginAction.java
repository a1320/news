package com.gdglc.news.action.user;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gdglc.news.domain.user.UserInfo;

public class LoginAction extends HttpServlet{

	/** serialVersionUID */
	private static final long serialVersionUID = 7537093115110989074L;

	
	@Override
	public void init() throws ServletException {
		System.out.println("初始化LoginAction");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		//获取用户名
		String name = request.getParameter("name");
		//获取密码
		String pwd = request.getParameter("pwd");
		if(null==name){
			return;
		}
		//根据用户名和密码查看是否存在该用户
		if(!"".equals(name)){
			//如果存在，把用户信息存放到session
			UserInfo user = new UserInfo();
			user.setName(name);
			HttpSession session = request.getSession();//
			System.out.println(session);
			session.setAttribute("user", user);
			//添加cookie到客户端 [id:10,name:30]
			Cookie userCookie = new Cookie("userName",URLEncoder.encode(name,"utf-8"));
			userCookie.setMaxAge(600);
			//设置只支持http，防止页面使用js读取或修改该cookie
			userCookie.setHttpOnly(true);
			//设置有效路径 /
			userCookie.setPath(path);
			//userCookie.setDomain(pattern);
			System.out.println(userCookie.getPath()); 
			response.addCookie(userCookie);
			//session.setMaxInactiveInterval(10);
			//重定向到指定页面（跳转到首页）
			String uri = path+"/index.jsp";
			String urlPath = response.encodeRedirectURL(uri);
			System.out.println("urlPath = "+urlPath);
			//String urlPathTwo = response.encodeURL("http://127.0.0.1:8888");
			//System.out.println("urlPathTwo="+urlPathTwo);
			response.sendRedirect(urlPath);
			return;
		}
		response.sendRedirect(path+"/login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("执行post提交");
		doGet(request, response);
	}
	
}
