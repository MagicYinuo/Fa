package com.example.familyfd.bean;

public class Stockjobber {
	String name;
	int img;
	String introduce;
	//优惠
	String benefit1;
	String benefit2;
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
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getBenefit1() {
		return benefit1;
	}
	public void setBenefit1(String benefit1) {
		this.benefit1 = benefit1;
	}
	public String getBenefit2() {
		return benefit2;
	}
	public void setBenefit2(String benefit2) {
		this.benefit2 = benefit2;
	}
	public Stockjobber(String name, int img, String introduce, String benefit1,
			String benefit2) {
		super();
		this.name = name;
		this.img = img;
		this.introduce = introduce;
		this.benefit1 = benefit1;
		this.benefit2 = benefit2;
	}
	public Stockjobber() {
		super();
	}
	
	
	
}
