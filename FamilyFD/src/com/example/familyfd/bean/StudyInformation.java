package com.example.familyfd.bean;

public class StudyInformation {
	int img;
	String name;
	String tip;
	String time;
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
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public StudyInformation(int img, String name, String tip, String time) {
		super();
		this.img = img;
		this.name = name;
		this.tip = tip;
		this.time = time;
	}
	public StudyInformation() {
		super();
	}
	
	
}
