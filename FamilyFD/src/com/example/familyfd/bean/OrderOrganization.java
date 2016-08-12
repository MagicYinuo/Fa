package com.example.familyfd.bean;

public class OrderOrganization {
	
	String name;
	String introduce;
	String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public OrderOrganization(String name, String introduce, String address) {
		super();
		this.name = name;
		this.introduce = introduce;
		this.address = address;
	}
	public OrderOrganization() {
		super();
	}
	
	
}
