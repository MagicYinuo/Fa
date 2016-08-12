package com.example.familyfd.bean;


//首页中竖向滚动的广告
public class IndexNotice {
	String title;
	
	String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "IndexNotice [title=" + title + ", content=" + content + "]";
	}

	public IndexNotice(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public IndexNotice() {
		super();
	}
	
	
}
