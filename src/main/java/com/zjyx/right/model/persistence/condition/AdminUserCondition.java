package com.zjyx.right.model.persistence.condition;

import java.util.List;

import com.zjyx.right.constants.Constants;
import com.zjyx.right.model.persistence.AdminUser;

public class AdminUserCondition extends AdminUser{
	private int onePageSize=Constants.DEFAULT_ONEPAGESIZE;
	private int currentPage=1;//当前�?
	private boolean needTotalResults;//是否�?要查询�?�数
	private int beginNum;
	private String real_name;//姓名
	private String email;//邮箱
	private String mobile;//电话
	private List<Integer> adminIds;
	public int getOnePageSize() {
		return onePageSize;
	}
	public void setOnePageSize(int onePageSize) {
		this.onePageSize = onePageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public boolean isNeedTotalResults() {
		return needTotalResults;
	}
	public void setNeedTotalResults(boolean needTotalResults) {
		this.needTotalResults = needTotalResults;
	}
	public int getBeginNum() {
		return beginNum;
	}
	public void setBeginNum(int beginNum) {
		this.beginNum = beginNum;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public List<Integer> getAdminIds() {
		return adminIds;
	}
	public void setAdminIds(List<Integer> adminIds) {
		this.adminIds = adminIds;
	}
	
}
