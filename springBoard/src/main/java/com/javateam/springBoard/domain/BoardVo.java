package com.javateam.springBoard.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
// import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class BoardVo {
	
	@Id
	private int articleid;
	
	@NotNull
	//@NotEmpty(message="글제목을 입력하십시오.")
	@Size(min=2, max=200, message="글제목을 200자 이내로 입력하십시오.")
	private String title;
	
	@NotNull
	//@NotEmpty(message="작성자를 입력하십시오.")
	@Size(min=2, max=20, message="작성자를 20자 이내로 입력하십시오.")
	private String userName;
	
	// @Temporal(TemporalType.DATE)
	// @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date writeDate;
	
	private String type;
	private String email;
	private String homeUrl;
	private int parentArticleid;
	private int hits;
	
	@NotNull
	//@NotEmpty(message="글 내용을 입력하십시오.")
	@Size(min=1, max=4000, message="글내용을 4000자 이내로 입력하십시오.")
	private String content;
	
	//@NotNull
	//@NotEmpty(message="패쓰워드를 입력하십시오.")
	@Size(min=8, max=20, message="패쓰워드를 8~20자 이내로 입력하십시오.")
	private String passwd;

	public BoardVo() {}

	/**
	 * 생성자(setters)
	 * @param articleid 아이디
	 * @param title 글제목
	 * @param userName 작성자
	 * @param writeDate 작성일
	 * @param type 답변글 유형
	 * @param email 이메일
	 * @param homeUrl 관련링크
	 * @param parentArticleid 부모글 아이디(댓글 관련)
	 * @param hits 조회수
	 * @param content 글내용
	 * @param passwd 패쓰워드
	 */
	public BoardVo(int articleid, 
				   String title, 
				   String userName, 
				   Date writeDate, 
				   String type, 
				   String email,
				   String homeUrl, 
				   int parentArticleid, 
				   int hits, 
				   String content, 
				   String passwd) {
		this.articleid = articleid;
		this.title = title;
		this.userName = userName;
		this.writeDate = writeDate;
		this.type = type;
		this.email = email;
		this.homeUrl = homeUrl;
		this.parentArticleid = parentArticleid;
		this.hits = hits;
		this.content = content;
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardVo\n [articleid=");
		builder.append(articleid);
		builder.append(",\n title=");
		builder.append(title);
		builder.append(",\n userName=");
		builder.append(userName);
		builder.append(",\n writeDate=");
		builder.append(writeDate);
		builder.append(",\n type=");
		builder.append(type);
		builder.append(",\n email=");
		builder.append(email);
		builder.append(",\n homeUrl=");
		builder.append(homeUrl);
		builder.append(",\n parentArticleid=");
		builder.append(parentArticleid);
		builder.append(",\n hits=");
		builder.append(hits);
		builder.append(",\n content=");
		builder.append(content);
		builder.append(",\n passwd=");
		builder.append(passwd);
		builder.append("]");
		return builder.toString();
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		
		this.writeDate = writeDate;
		
		/*if (writeDate != null) {
	        this.writeDate = new Date(writeDate.getTime());
	    } else {
	        this.writeDate = writeDate;
	    }*/
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeUrl() {
		return homeUrl;
	}

	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}

	public int getParentArticleid() {
		return parentArticleid;
	}

	public void setParentArticleid(int parentArticleid) {
		this.parentArticleid = parentArticleid;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articleid;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + hits;
		result = prime * result + ((homeUrl == null) ? 0 : homeUrl.hashCode());
		result = prime * result + parentArticleid;
		result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((writeDate == null) ? 0 : writeDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BoardVo))
			return false;
		BoardVo other = (BoardVo) obj;
		if (articleid != other.articleid)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (hits != other.hits)
			return false;
		if (homeUrl == null) {
			if (other.homeUrl != null)
				return false;
		} else if (!homeUrl.equals(other.homeUrl))
			return false;
		if (parentArticleid != other.parentArticleid)
			return false;
		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (writeDate == null) {
			if (other.writeDate != null)
				return false;
		} else if (!writeDate.equals(other.writeDate))
			return false;
		return true;
	}
	
}
