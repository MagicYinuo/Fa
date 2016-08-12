package com.example.familyfd.bean;

public class User {

	int id;
	String username;
	String password;
	String phonenum;
	String name;
	
	//每月总收入
	double allincome;
	//风险偏好得分
	int RiskAPPScore;
	//每月总支出
	double allpay;
	public int getRiskAPPScore() {
		return RiskAPPScore;
	}

	public void setRiskAPPScore(int riskAPPScore) {
		RiskAPPScore = riskAPPScore;
	}

	public double getAllincome() {
		return allincome;
	}

	public void setAllincome(double allincome) {
		this.allincome = allincome;
	}

	public double getAllpay() {
		return allpay;
	}

	public void setAllpay(double allpay) {
		this.allpay = allpay;
	}

	double livecost;
	public double getLivecost() {
		return livecost;
	}

	public void setLivecost(double livecost) {
		this.livecost = livecost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 身份证
	String ID_NUM;
	// 头像
	String path;
	String sex;
	int age;
	double birthday;
	String profession;
	// 积分
	int score;
	//等级
	int level;
	// 金币
	int corn;
	//配偶姓名
	String matename;
	//配偶年龄
	int mateage;
	//配偶职业
	String mateprofession;
	//子女数量
	int childnum;
	//是否已婚
	boolean isMarried;
	//子女年龄
	int child1age;
	int child2age;
	int child3age;
	int child4age;
	
	//年收入
	Double YearIncome;



	public Double getYearIncome() {
		return YearIncome;
	}

	public void setYearIncome(Double yearIncome) {
		YearIncome = yearIncome;
	}

	public int getChild1age() {
		return child1age;
	}

	public void setChild1age(int child1age) {
		this.child1age = child1age;
	}

	public int getChild2age() {
		return child2age;
	}

	public void setChild2age(int child2age) {
		this.child2age = child2age;
	}

	public int getChild3age() {
		return child3age;
	}

	public void setChild3age(int child3age) {
		this.child3age = child3age;
	}

	public int getChild4age() {
		return child4age;
	}

	public void setChild4age(int child4age) {
		this.child4age = child4age;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public int getChildnum() {
		return childnum;
	}

	public void setChildnum(int childnum) {
		this.childnum = childnum;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getMatename() {
		return matename;
	}

	public void setMatename(String matename) {
		this.matename = matename;
	}

	public int getMateage() {
		return mateage;
	}

	public void setMateage(int mateage) {
		this.mateage = mateage;
	}

	public String getMateprofession() {
		return mateprofession;
	}

	public void setMateprofession(String mateprofession) {
		this.mateprofession = mateprofession;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	// 财务属性
	int caiwu_num;

	// 推送ID
	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public User(int id, String username, String password, String phonenum,
			String iD_NUM, String path, String sex, int age, double birthday,
			int score, int level, int corn, int caiwu_num) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phonenum = phonenum;
		ID_NUM = iD_NUM;
		this.path = path;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.score = score;
		this.level = level;
		this.corn = corn;
		this.caiwu_num = caiwu_num;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getID_NUM() {
		return ID_NUM;
	}

	public void setID_NUM(String iD_NUM) {
		ID_NUM = iD_NUM;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getBirthday() {
		return birthday;
	}

	public void setBirthday(double birthday) {
		this.birthday = birthday;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCorn() {
		return corn;
	}

	public void setCorn(int corn) {
		this.corn = corn;
	}

	public int getCaiwu_num() {
		return caiwu_num;
	}

	public void setCaiwu_num(int caiwu_num) {
		this.caiwu_num = caiwu_num;
	}

}
