package com.blog.ram.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.ram.entities.Category;
import com.blog.ram.exceptions.ResourceNotFoundException;
import com.blog.ram.payloads.CategoryDto;
import com.blog.ram.repositories.CategoryRepo;
import com.blog.ram.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category category=	this.mapper.map(categoryDto, Category.class);
		Category addedCategory=this.categoryRepo.save(category);
		return this.mapper.map(addedCategory, CategoryDto.class);
	
	}	
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category category=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category", "Category Id",categoryId));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updateCategory=this.categoryRepo.save(category);
		
		return this.mapper.map(updateCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category", "Category Id",categoryId));
		
		this.categoryRepo.delete(category);

	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category category=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category", "Category Id",categoryId));
		
		return this.mapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
	List<Category> categories=	this.categoryRepo.findAll();
	List<CategoryDto>  catDto=categories.stream().map((cat)->this.mapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catDto;
	}

}
