package com.gdglc.news.domain.common;

import java.io.Serializable;
import java.util.List;

public class PageInfo<T> implements Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = 3651665890623696752L;
	//当前页
	int currentPage = 1;
	//总页数
	int totalPage;
	//每页显示条数
	int pageSize = 2;
	//记录总数
	int totalSize;
	//显示的结果集
	List<T> list;
	public int getCurrentPage() {
		if(currentPage<=0){
			currentPage = 1;
		}else if(currentPage>totalPage){
			currentPage = totalPage;
		}
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
		this.totalPage = totalSize/pageSize;
		if(totalSize%pageSize!=0){
			this.totalPage = this.totalPage+1;
		}
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	
}
