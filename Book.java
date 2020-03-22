package com.wdzl.entity;

public class Book {
	private long id;
	private int type;
	private String summary;
	private String title;

	public long getById() {
		return id;
	}
    public void setByID(long id){this.id=id;}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}
