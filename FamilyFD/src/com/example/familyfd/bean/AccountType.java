package com.example.familyfd.bean;

public class AccountType {
	int img;
	String name;
	public int getImg() {
		return img;
	}
	public void setImg(int img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AccountType(int img, String name) {
		super();
		this.img = img;
		this.name = name;
	}
	public AccountType() {
		super();
	}
	@Override
	public String toString() {
		return "AccountType [img=" + img + ", name=" + name + "]";
	}
	
	
}
