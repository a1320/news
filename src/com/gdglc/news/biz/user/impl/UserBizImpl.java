package com.gdglc.news.biz.user.impl;

import java.util.List;

import com.gdglc.news.biz.user.IUserBiz;
import com.gdglc.news.dao.user.IUserDao;
import com.gdglc.news.dao.user.impl.UserDaoImpl;
import com.gdglc.news.domain.common.PageInfo;
import com.gdglc.news.domain.user.UserInfo;

public class UserBizImpl implements IUserBiz{
	private IUserDao dao = new UserDaoImpl();;
	
	public IUserDao getDao() {
		return dao;
	}

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	public UserBizImpl(){
		dao = new UserDaoImpl();
	}
	@Override
	public List<UserInfo> findList() {
		return dao.findList();
	}

	@Override
	public void findList(PageInfo<UserInfo> pageInfo) {
		//查询符合条件的记录数
		int totalSize = dao.findCount(null);
		pageInfo.setTotalSize(totalSize);
		//查询出符合条件的记录
		List<UserInfo> resultList = dao.findList(pageInfo.getCurrentPage(), pageInfo.getPageSize(), null);
		pageInfo.setList(resultList);
		//返回一个PageInfo对象
	}

	@Override
	public void add(UserInfo info) {
		//规则检查
		dao.add(info);
		
	}

	@Override
	public void update(UserInfo info) {
		dao.update(info);
		
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
		
	}

	@Override
	public UserInfo findById(Integer id) {	
		return dao.findById(id);
	}

}
