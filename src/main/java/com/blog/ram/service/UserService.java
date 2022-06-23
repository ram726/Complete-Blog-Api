package com.blog.ram.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.ram.payloads.UserDto;

public interface UserService {
	UserDto cretaeUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
}
