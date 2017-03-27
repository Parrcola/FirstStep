package com.javateam.springBoard.domain;

public class BoardMap {
	
	private int articleid;
	private String title;
	private String userName;
	private String writeDate;
	private String type;
	private int hits;
	
	@Override
	public String toString() {
		return "BoardMap [articleid=" + articleid + ", title=" + title + ", userName=" + userName + ", writeDate="
				+ writeDate + ", type=" + type + ", hits=" + hits + "]";
	}
	
	public int getArticleid() {
		return articleid;
	}
	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	
}
