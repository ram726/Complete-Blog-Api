package com.blog.ram.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.ram.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
