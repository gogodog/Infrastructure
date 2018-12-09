package com.zjyx.right.test.model;

import java.util.Date;

import com.alibaba.fastjson.JSON;

public class Person {

	private String name;
	private int age;
	private String work;
//	private Date ctime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
//	public Date getCtime() {
//		return ctime;
//	}
//	public void setCtime(Date ctime) {
//		this.ctime = ctime;
//	}
//	@Override
//	public String toString() {
//		return JSON.toJSONString(this);
//	}
    	
	
}
