package com.example.familyfd.bean;

//一次预约
public class Order {
	//理财师姓名
	String name;
	//理财师头像
	String path;
	//理财师介绍
	String introduce;
	//预约时间
	String time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Order(String name, String path, String introduce, String time) {
		super();
		this.name = name;
		this.path = path;
		this.introduce = introduce;
		this.time = time;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [name=" + name + ", path=" + path + ", introduce="
				+ introduce + ", time=" + time + "]";
	}
	
	
	
	
}
