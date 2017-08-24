package com.gdglc.news.domain.user;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 
 * 用户信息对象
 * <p>
 * 
 * @author allan
 * @version $Date: 2017年8月11日 $
 */
public class UserInfo implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = 7525603371017422905L;
	//用户id
	private Integer id;
	//用户名
	private String name;
	//权限集合
	private List<String> authList;
	
	private Date createDate;
	/**
	 * 获取用户名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置用户名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getAuthList() {
		return authList;
	}
	public void setAuthList(List<String> authList) {
		this.authList = authList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getTest(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(this.getCreateDate());
	}
	
	/*@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", authList="
				+ authList + "]";
	}*/
	
	
}
