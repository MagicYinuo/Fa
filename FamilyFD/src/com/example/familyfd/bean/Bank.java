package com.example.familyfd.bean;

public class Bank {
	String name;
	int img;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getImg() {
		return img;
	}
	public void setImg(int img) {
		this.img = img;
	}
	public Bank(String name, int img) {
		super();
		this.name = name;
		this.img = img;
	}
	public Bank() {
		super();
	}
	
	
}
