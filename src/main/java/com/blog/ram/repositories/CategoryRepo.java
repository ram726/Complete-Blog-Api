package com.blog.ram.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.ram.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
