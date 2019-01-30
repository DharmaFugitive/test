package com.aowin.model;

import java.util.List;

public class Page {
	private Integer currentPage;
	private Integer totalPage;
	private Integer pageSize;
	private Integer begin;
	
	private List data;
	
	public Page() {
		pageSize=4;
	}
	
	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
		this.begin = (currentPage-1)*pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", totalPage=" + totalPage + ", pageSize=" + pageSize + ", data="
				+ data + ", begin=" + begin + "]";
	}
	
	
	
}
