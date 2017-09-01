package com.gdglc.news.dao.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gdglc.news.dao.user.BaseDao;
import com.gdglc.news.dao.user.IUserDao;
import com.gdglc.news.domain.common.PageInfo;
import com.gdglc.news.domain.user.UserInfo;

public class UserDaoImpl extends BaseDao implements IUserDao {
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
	
	public void findList(PageInfo<UserInfo> pageInfo){
		List<UserInfo> resultList = new ArrayList<UserInfo>();
		//先有一个总记录数
		int totalSize = userList.size();
		pageInfo.setTotalSize(totalSize);
		//找到获取数据的开始位置
		int pageSize = pageInfo.getPageSize();
		int begin = (pageInfo.getCurrentPage()-1)*pageSize;
		int end = begin+pageSize;
		for(;begin<end;begin++){
			if(begin<totalSize){
				resultList.add(userList.get(begin));
			}
		}
		pageInfo.setList(resultList);
	}

	@Override
	public void add(UserInfo info) {
		info.setId(userList.size()+1);
		if("admin".equals(info.getName())){
			throw new RuntimeException("模拟用户添加失败，用户名不能为admin");
		}
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
//		IUserDao dao = new UserDaoImpl();
//		List<UserInfo> userList = dao.findList();
//		System.out.println(userList.size());
		Integer i = 1;
		System.out.println(i++);
		System.out.println(++i);
	}

	@Override
	public int findCount(UserInfo userInfo) {
		Connection con = getConnection();
		if(null==con){
			return 0;
		}
		String sql = "select count(1) count from news";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt("count");
			}
		} catch (SQLException e) {
			// todo Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null!=rs){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					rs = null;
				}
			}
			if(null!=ps){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					ps = null;
				}
			}
			if(null!=con){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					con = null;
				}
			}
		}
		
		
		return 0;
	}

	@Override
	public List<UserInfo> findList(int currentPage, int pageSize, UserInfo userInfo) {
		List<UserInfo> resultList = new ArrayList<UserInfo>();
		Connection con = getConnection();
		if(null==con){
			return resultList;
		}
		String sql = "select top "+pageSize+" nauthor,nid from news where nid not in (select top "+(currentPage-1)*pageSize+" nid from news)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("nauthor");
				int id = rs.getInt("nid");
				UserInfo info = new UserInfo();
				info.setName(name);
				info.setId(id);
				resultList.add(info);
			}
		} catch (SQLException e) {
			// todo Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null!=rs){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					rs = null;
				}
			}
			if(null!=ps){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					ps = null;
				}
			}
			if(null!=con){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					con = null;
				}
			}
		}
		return resultList;
		
	}
}
