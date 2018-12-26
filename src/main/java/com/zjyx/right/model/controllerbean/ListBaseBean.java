package com.zjyx.right.model.controllerbean;

public class ListBaseBean {

	private int currentPage = 1;

	private int onePageSize;

	private long totalResults;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getOnePageSize() {
		return this.onePageSize = onePageSize <= 0 ? 10 : onePageSize;
	}

	public void setOnePageSize(int onePageSize) {
		this.onePageSize = onePageSize;
	}

	public long getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(long totalResults) {
		this.totalResults = totalResults;
	}

	public int getTotalPage() {
		double totalPage = (double) totalResults / getOnePageSize();
		return (int) Math.ceil(totalPage);
	}

	// 数据库第一条数据
	public int getBeginNum() {
		if(currentPage == 0){
			currentPage = 1;
		}
		return (currentPage - 1) * onePageSize;
	}
}
