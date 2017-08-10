package com.neusoft.dao.page;

import java.util.List;
//分页类
public class Page {
	// 要显示的所有的数据
	private List<?> data;
	//总共多少条记录
	private int allRow;
	// 每页显示多少条数据
	private int pageSize;
	//总共有多少页
	private int totalPage;
	//当前在第几页
	private int currentPage;
	//是否有下一页
	private boolean hasNextPage;
	//是否有上一页
	private boolean hasPrePage;
	//是否是第一页
	private boolean isFirstPage;
	//是否是最后一页
	private boolean isLastPage;
	//通过构造方法传递要显示的所有数据
	public Page(List<?>data){
		this.data = data;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow() {
		allRow = data.size();
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage() {
		totalPage = (allRow%pageSize)==0?(allRow/pageSize):(allRow/pageSize+1);
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public boolean isHasNextPage() {
		if (currentPage==totalPage) {
			return false;
		}else {
			return true;
		}
	}
//	public void setHasNextPage(boolean hasNextPage) {
//		this.hasNextPage = hasNextPage;
//	}
	public boolean isHasPrePage() {
		if (currentPage==1) {
			return false;
		}else {
			return true;
		}
	}
//	public void setHasPrePage(boolean hasPrePage) {
//		this.hasPrePage = hasPrePage;
//	}
	public boolean isFirstPage() {
		if (currentPage==1) {
			return true;
		}else {
			return false;
		}
	}
//	public void setFirstPage(boolean isFirstPage) {
//		this.isFirstPage = isFirstPage;
//	}
	public boolean isLastPage() {
		if (currentPage==totalPage) {
			return true;
		}else {
			return false;
		}
	}
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	
}
