package com.gdglc.news.dao.user.impl;

import java.util.ArrayList;
import java.util.List;

import com.gdglc.news.dao.user.IUserDao;
import com.gdglc.news.domain.user.UserInfo;

public class UserDaoImpl implements IUserDao {
	private static List<UserInfo> userList;
	static{
		userList = new ArrayList<UserInfo>();
		for(int i=1;i<=3;i++){
			UserInfo info = new UserInfo();
			info.setId(i);
			info.setName("user"+i);
			userList.add(info);
		}
	}
	@Override
	public List<UserInfo> findList() {
		return userList;
	}

	@Override
	public void add(UserInfo info) {
		userList.add(info);
	}

	@Override
	public void update(UserInfo info) {
		//获取
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserInfo findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
