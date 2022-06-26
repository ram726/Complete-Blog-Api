package com.blog.ram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.ram.config.AppConstants;
import com.blog.ram.payloads.ApiResponse;
import com.blog.ram.payloads.PostDto;
import com.blog.ram.payloads.PostResponse;
import com.blog.ram.service.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(
			@RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId			
			)
	{
		PostDto createPost=(PostDto) this.postService.createPost(postDto,userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	//get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		List<PostDto>postDtos=this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
	}
	
	//get by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
		List<PostDto>postDtos=this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
	}
	
	//get all post
	@GetMapping("/posts")
	public ResponseEntity<PostResponse>getAllPost(
			@RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false)Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue =AppConstants.PAGE_SIZE,required = false)Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue =AppConstants.SORT_BY,required = false) String sortBy,
			@RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR,required = false)String sortDir
			){
		
//		List<PostDto>postDtos=this.postService.getALlPost(pageNumber,pageSize);
		
		PostResponse postResponse=this.postService.getALlPost(pageNumber,pageSize,sortBy,sortDir);
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
		
	}
	
	//get post by id
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		System.out.print(postId);
		return ResponseEntity.ok(this.postService.getPostById(postId));
		
	}
	
	//delete post by id
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePostById(@PathVariable Integer postId) {
		
		this.postService.deletePost(postId);
		return new ApiResponse("post is deleted with id:"+postId,true);
	}
	//update post by id
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable Integer postId) {
		
		PostDto updateDto=this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updateDto,HttpStatus.OK);
	}
	
	//search
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>>searchPostByTitle(@PathVariable("keywords") String keywords){
		List<PostDto> resultDtos=this.postService.searchPost(keywords);
		return new ResponseEntity<List<PostDto>>(resultDtos,HttpStatus.OK);
	}

}
