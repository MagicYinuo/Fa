package com.example.familyfd.bean;

import java.io.Serializable;

public class Insurer implements Serializable {
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
	public Insurer(String name, int img) {
		super();
		this.name = name;
		this.img = img;
	}
	public Insurer() {
		super();
	}
	
	
	
	
}
