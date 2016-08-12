package com.example.familyfd.bean;

public class StudyVideo {
	int img;
	String name;
	String url;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public StudyVideo(int img, String name, String url) {
		super();
		this.img = img;
		this.name = name;
		this.url = url;
	}
	public StudyVideo() {
		super();
	}
	
	
}
