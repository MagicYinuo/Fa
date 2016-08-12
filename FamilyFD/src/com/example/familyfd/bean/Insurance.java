package com.example.familyfd.bean;

import java.io.Serializable;

public class Insurance implements Serializable {
	// 简介
	String introduce;
	// 承保年龄
	String age;
	// 承保期限
	String term;
	// 价格
	int price;
	String name;
	//标题图片
	int img;
	//详情图片
	int detailimg;

	public int getDetailimg() {
		return detailimg;
	}

	public void setDetailimg(int detailimg) {
		this.detailimg = detailimg;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

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

	public Insurance(String introduce, String age, String term, int price,
			String name, int img) {
		super();
		this.introduce = introduce;
		this.age = age;
		this.term = term;
		this.price = price;
		this.name = name;
		this.img = img;
	}

	public Insurance() {
		super();
	}

}
