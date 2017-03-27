package com.javateam.springBoard.domain;

import java.util.ArrayList;

public class BoardList {
	
	private ArrayList <Integer> articleid;
	private ArrayList <String> 	title;
	private ArrayList <String> 	userName;
	private ArrayList <String> 	writeDate;
	private ArrayList <String> 	type;
	private ArrayList <String> 	email;
	private ArrayList <String>  homeUrl;
	private ArrayList <Integer> parentArticleid;
	private ArrayList <Integer> hits;
	private ArrayList <String>  content;
	private ArrayList <String>  passwd;
	
	public ArrayList<Integer> getArticleid() {
		return articleid;
	}
	public void setArticleid(ArrayList<Integer> articleid) {
		this.articleid = articleid;
	}
	public ArrayList<String> getTitle() {
		return title;
	}
	public void setTitle(ArrayList<String> title) {
		this.title = title;
	}
	public ArrayList<String> getUserName() {
		return userName;
	}
	public void setUserName(ArrayList<String> userName) {
		this.userName = userName;
	}
	public ArrayList<String> getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(ArrayList<String> writeDate) {
		this.writeDate = writeDate;
	}
	public ArrayList<String> getType() {
		return type;
	}
	public void setType(ArrayList<String> type) {
		this.type = type;
	}
	public ArrayList<String> getEmail() {
		return email;
	}
	public void setEmail(ArrayList<String> email) {
		this.email = email;
	}
	public ArrayList<String> getHomeUrl() {
		return homeUrl;
	}
	public void setHomeUrl(ArrayList<String> homeUrl) {
		this.homeUrl = homeUrl;
	}
	public ArrayList<Integer> getParentArticleid() {
		return parentArticleid;
	}
	public void setParentArticleid(ArrayList<Integer> parentArticleid) {
		this.parentArticleid = parentArticleid;
	}
	public ArrayList<Integer> getHits() {
		return hits;
	}
	public void setHits(ArrayList<Integer> hits) {
		this.hits = hits;
	}
	public ArrayList<String> getContent() {
		return content;
	}
	public void setContent(ArrayList<String> content) {
		this.content = content;
	}
	public ArrayList<String> getPasswd() {
		return passwd;
	}
	public void setPasswd(ArrayList<String> passwd) {
		this.passwd = passwd;
	}
	
}