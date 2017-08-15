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
		info.setId(userList.size()+1);
		userList.add(info);
	}

	@Override
	public void update(UserInfo info) {
		for (UserInfo userInfo : userList) {
			if(userInfo.getId().equals(info.getId())){
				userInfo.setName(info.getName());
				return;
			}
		}
	}

	@Override
	public void delete(Integer id) {
		for(int i=0;i<userList.size();i++){
			UserInfo info = userList.get(i);
			if(id.equals(info.getId())){
				userList.remove(i);
				return;
			}
		}	
	}

	@Override
	public UserInfo findById(Integer id) {
		for (UserInfo info : userList) {
			if(info.getId().equals(id)){
				return info;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		IUserDao dao = new UserDaoImpl();
		List<UserInfo> userList = dao.findList();
		System.out.println(userList.size());
	}
}
