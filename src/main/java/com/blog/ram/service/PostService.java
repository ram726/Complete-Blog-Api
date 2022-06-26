package com.blog.ram.service;

import java.util.List;

import com.blog.ram.entities.Post;
import com.blog.ram.payloads.PostDto;
import com.blog.ram.payloads.PostResponse;

public interface PostService {
	
	
	//create
	PostDto createPost(PostDto dto,Integer userId,Integer categoryId);
	PostDto updatePost(PostDto dto,Integer postId);
	void deletePost(Integer postId);
//	List<PostDto>getALlPost(Integer pageNumber,Integer pageSize);
	PostResponse getALlPost(Integer pageNumber,Integer pageSize);
	PostDto getPostById(Integer postId);
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	List<PostDto> getPostsByUser(Integer userId);
	
	List<Post> searchPost(String keyword);

}
