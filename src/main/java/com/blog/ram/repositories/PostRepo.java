package com.blog.ram.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.ram.entities.Category;
import com.blog.ram.entities.Post;
import com.blog.ram.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post>findByUser(User user);
	
	List<Post>findByCategory(Category category);
	
	List<Post>findByTitleContaining(String title);

}
