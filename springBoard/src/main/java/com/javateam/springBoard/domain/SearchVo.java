package com.javateam.springBoard.domain;

public class SearchVo {
	
	private String search_gubun;
	private String search_word;
	
	@Override
	public String toString() {
		return String.format(" [search_gubun=%s, search_word=%s]",
				search_gubun, search_word);
	}
	
	public String getSearch_gubun() {
		return search_gubun;
	}
	public String getSearch_word() {
		return search_word;
	}
	public void setSearch_gubun(String search_gubun) {
		this.search_gubun = search_gubun;
	}
	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}

}
