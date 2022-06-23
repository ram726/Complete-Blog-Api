package com.blog.ram.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.ram.entities.Category;
import com.blog.ram.entities.Post;
import com.blog.ram.entities.User;
import com.blog.ram.exceptions.ResourceNotFoundException;
import com.blog.ram.payloads.PostDto;
import com.blog.ram.repositories.CategoryRepo;
import com.blog.ram.repositories.PostRepo;
import com.blog.ram.repositories.UserRepo;
import com.blog.ram.service.PostService;

import net.bytebuddy.asm.Advice.This;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	

	@Override
	public PostDto createPost(PostDto dto,Integer userId,Integer categoryId) {
		
		User user=this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User","User Id",userId));
		
		Category category=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category", "Category Id",categoryId));
	
		Post post=this.mapper.map(dto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost=this.postRepo.save(post);
		
		return this.mapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto dto, Integer postId) {
		
		
		Post post=this.postRepo.findById(postId).orElseThrow(()->
		new ResourceNotFoundException("Post", "post id", postId));
		
		post.setTitle(dto.getTitle());
		post.setContent(dto.getContent());
		post.setImageName(dto.getImageName());
		
		Post updatedPost= this.postRepo.save(post);
		
		PostDto postDto=this.mapper.map(updatedPost, PostDto.class);
				
		return postDto;
	}

	@Override
	public void deletePost(Integer postId) {
		
		Post post=this.postRepo.findById(postId).orElseThrow(()->
		new ResourceNotFoundException("Post", "post id", postId));
		
		this.postRepo.delete(post);

	}

	@Override
	public List<PostDto> getALlPost() {
		
		List<Post>posts =this.postRepo.findAll();
		List<PostDto>postDtos=posts.stream().map((post)->this.mapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}
	@Override
	public PostDto getPostById(Integer postId) {
		
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "post id", postId));
		
		PostDto postDto=this.mapper.map(post, PostDto.class);
		
		return postDto;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(
				()->new ResourceNotFoundException("Category", "category id", categoryId));
		
		List<Post>posts=this.postRepo.findByCategory(category);
		List<PostDto> postDtos =posts.stream().map((post)->this.mapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(
				()->new ResourceNotFoundException("User", "user id", userId));
		
		List<Post>posts=this.postRepo.findByUser(user);
		List<PostDto> postDtos =posts.stream().map((post)->this.mapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		
		return postDtos;
		
	}

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}



}