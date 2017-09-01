package com.gdglc.news.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdglc.news.biz.user.IUserBiz;
import com.gdglc.news.biz.user.impl.UserBizImpl;
import com.gdglc.news.dao.user.IUserDao;
import com.gdglc.news.dao.user.impl.UserDaoImpl;
import com.gdglc.news.domain.common.PageInfo;
import com.gdglc.news.domain.user.UserInfo;

public class ShowListAction extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getContextPath();
		//设置编码格式，解决post的乱码问题
		request.setCharacterEncoding("utf-8");
		//获取请求参数
		//封装业务方法参数
		//调用业务方法，获取结果
		IUserBiz biz = new UserBizImpl();
		int currentPage = 1;
		String currentPageStr = request.getParameter("currentPage");
		if(null!=currentPageStr&&!"".equals(currentPageStr.trim())){
			try{
				currentPage = Integer.parseInt(currentPageStr);
			}catch(Exception e){
				e.printStackTrace();
				currentPage = 1;
			}
		}
		PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>();
		pageInfo.setCurrentPage(currentPage);
		biz.findList(pageInfo);
		//把userList添加到了request作用域，也可以理解为在request对象中添加了额外属性
		request.setAttribute("pageInfo", pageInfo);
		//List<UserInfo> userList = dao.findList();
		//根据调用结果确定跳转页面（页面的地址＋跳转的方式）
		request.getRequestDispatcher("/view/user/list.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
