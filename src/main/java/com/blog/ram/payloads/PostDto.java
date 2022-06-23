package com.blog.ram.payloads;

import java.util.Date;

import com.blog.ram.entities.Category;
import com.blog.ram.entities.User;

public class PostDto {
	
	private Integer postIdInteger;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private CategoryDto category;
	private UserDto user;
	
	PostDto(){}

	@Override
	public String toString() {
		return "PostDto [postIdInteger=" + postIdInteger + ", title=" + title + ", content=" + content + ", imageName="
				+ imageName + ", addedDate=" + addedDate + ", category=" + category + ", user=" + user + "]";
	}

	public PostDto(Integer postIdInteger, String title, String content, String imageName, Date addedDate,
			CategoryDto category, UserDto user) {
		super();
		this.postIdInteger = postIdInteger;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
	}

	public Integer getPostIdInteger() {
		return postIdInteger;
	}

	public void setPostIdInteger(Integer postIdInteger) {
		this.postIdInteger = postIdInteger;
	}

	public PostDto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
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

	public PostDto(String title, String content, String imageName, Date addedDate, CategoryDto category, UserDto user) {
		super();
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
}
