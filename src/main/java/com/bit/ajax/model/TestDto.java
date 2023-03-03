package com.bit.ajax.model;

public class TestDto {
	private String name,title,content;
//생성자
    public TestDto(String name , String title, String content){
	    this.name = name;
	    this.title = title;
	    this.content = content;
	    
    }
//getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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


}