package com.gdglc.news.filter;

import java.io.IOException;
import java.lang.reflect.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Enconding
 */
@WebFilter(urlPatterns={"/*"})
public class EncondingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncondingFilter() {
       System.out.println("创建EncondingFilter");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		 System.out.println("销毁EncondingFilter");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 System.out.println("过滤EncondingFilter");
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 //控制请求是否继续，如果不调用，则不会继续处理请求
		 chain.doFilter(request, response);
		 System.out.println("EncondingFilter结束");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("初始化EncondingFilter");
	}

}
