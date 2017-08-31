package com.gdglc.news.dao.user;

import java.util.List;

import com.gdglc.news.domain.common.PageInfo;
import com.gdglc.news.domain.user.UserInfo;

public interface IUserDao {
	/**
	 * 获取全部用户信息
	 * @return
	 */
	public List<UserInfo> findList();
	/**
	 * 
	 * @param currentPage 当前页
	 * @param pageSize 每页显示的条数
	 * @return
	 */
	public void findList(PageInfo<UserInfo> pageInfo);
	/**
	 * 添加用户信息
	 * @param info 用户信息对象
	 */
	public void add(UserInfo info);
	
	/**
	 * 修改用户信息
	 * @param info
	 */
	public void update(UserInfo info);
	
	/**
	 * 通过id删除用户信息
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 通过id获取用户信息
	 * @param id
	 * @return
	 */
	public UserInfo findById(Integer id);
}
