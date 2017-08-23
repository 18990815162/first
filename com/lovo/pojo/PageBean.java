package com.lovo.pojo;

public class PageBean {
 private int currentPage;
 private int totalPage;
 private int all;
 private int pageSize;
 private int startNumber;

public int getStartNumber() {
	startNumber= (currentPage-1)*pageSize;
	return startNumber;
}
public void setStartNumber(int startNumber) {
	this.startNumber = startNumber;
}
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}
public int getTotalPage() {
	if(all%pageSize==0){
		totalPage = all/pageSize;
	}else{
		totalPage = all/pageSize+1;
	}
	return totalPage;
}
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}
public int getAll() {
	return all;
}
public void setAll(int all) {
	this.all = all;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
}
