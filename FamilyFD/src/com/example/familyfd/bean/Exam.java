package com.example.familyfd.bean;

import java.util.List;

public class Exam {
	int Check=-1;
	public int getCheck() {
		return Check;
	}
	public void setCheck(int check) {
		Check = check;
	}
	String title;
	List<String> options;
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Exam() {
		super();
	}
	
	
	public Exam(String title, List<String> options, int id) {
		super();
		this.title = title;
		this.options = options;
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	@Override
	public String toString() {
		return "Exam [title=" + title + ", options=" + options + "]";
	}
	
	
	
}
