package com.example.familyfd.bean;

public class Fund {
	
	//基金名称
	String name;
	//基金特色
	String item;
	//近一年跌涨幅
	String fallrise;
	//基金代码
	String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getFallrise() {
		return fallrise;
	}
	public void setFallrise(String fallrise) {
		this.fallrise = fallrise;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Fund(String name, String item, String fallrise, String id) {
		super();
		this.name = name;
		this.item = item;
		this.fallrise = fallrise;
		this.id = id;
	}
	public Fund() {
		super();
	}
	
	
}
