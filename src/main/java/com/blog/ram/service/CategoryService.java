package com.blog.ram.service;

import java.util.List;

import com.blog.ram.payloads.CategoryDto;

public interface CategoryService {
	
	//create
	public CategoryDto createCategory(CategoryDto categoryDto);
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	//delete
	public void deleteCategory(Integer categoryId);
	//get
	public CategoryDto getCategory(Integer categoryId);
	//get all
	public List<CategoryDto> getCategories();

}
