package com.gdglc.news.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter(urlPatterns={"/*"})
public class FauthFilter implements Filter{

	@Override
	public void destroy() {
		// todo Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("进入权限检查");
		if(1==1){
			System.out.println("满足进入条件");
			chain.doFilter(request, response);
		}
		System.out.println("权限检查结束");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// todo Auto-generated method stub
		
	}

}
