package com.aowin.model;

public class News {
	private String id;
	private String title;
	private String description;
	private String content;
	private String createtime;
	private String author;
	private String type;
	private Integer intId;
	
	private User user;
	
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getIntId() {
		return intId;
	}


	public void setIntId(Integer intId) {
		this.intId = intId;
	}


	public News(Integer intId, String title, String description, String content, String createtime, String author,
			String type) {
		super();
		this.intId = intId;
		this.title = title;
		this.description = description;
		this.content = content;
		this.createtime = createtime;
		this.author = author;
		this.type = type;
	}


	public News( String title, String description, String content, String createtime, String author,
			String type) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
		this.createtime = createtime;
		this.author = author;
		this.type = type;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreattime() {
		return createtime;
	}
	public void setCreattime(String createtime) {
		this.createtime = createtime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content
				+ ", createtime=" + createtime + ", author=" + author + ", type=" + type + ", intId=" + intId
				+ ", user=" + user + "]";
	}


	
	
	
	
}
