package com.example.familyfd.bean;

public class FinancialPlanner {
	//头像
	int path;
	//姓名
	String name;
	//预约所需金币
	int golden;
	//职级
	String level;
	//所属机构
	String organization;
	//电话
	String phonenum;
	//介绍
	String introduce;
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	//工号
	String workID;
	//个人简历
	String vitae;
	public int getPath() {
		return path;
	}
	public void setPath(int path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGolden() {
		return golden;
	}
	public void setGolden(int golden) {
		this.golden = golden;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getWorkID() {
		return workID;
	}
	public void setWorkID(String workID) {
		this.workID = workID;
	}
	public String getVitae() {
		return vitae;
	}
	public void setVitae(String vitae) {
		this.vitae = vitae;
	}
	public FinancialPlanner() {
		super();
	}
	@Override
	public String toString() {
		return "FinancialPlanner [path=" + path + ", name=" + name
				+ ", golden=" + golden + ", level=" + level + ", organization="
				+ organization + ", phonenum=" + phonenum + ", introduce="
				+ introduce + ", workID=" + workID + ", vitae=" + vitae + "]";
	}
	public FinancialPlanner(int path, String name, int golden, String level,
			String organization, String phonenum, String introduce,
			String workID, String vitae) {
		super();
		this.path = path;
		this.name = name;
		this.golden = golden;
		this.level = level;
		this.organization = organization;
		this.phonenum = phonenum;
		this.introduce = introduce;
		this.workID = workID;
		this.vitae = vitae;
	}
	
	
	
	
}
