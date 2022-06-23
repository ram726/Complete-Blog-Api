package com.blog.ram.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.ram.entities.User;
import com.blog.ram.exceptions.ResourceNotFoundException;
import com.blog.ram.payloads.UserDto;
import com.blog.ram.repositories.UserRepo;
import com.blog.ram.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto cretaeUser(UserDto dto) {
		User user=this.dtoToUser(dto);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto dto, Integer userId) {
		User user=this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		
		user.setName(dto.getName());
		user.setAbout(dto.getAbout());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		
		User updateUser= userRepo.save(user);
		UserDto userDto= this.userToDto(updateUser);
		return userDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user=this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User>users= this.userRepo.findAll();
	List<UserDto>userDtos=	users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);

	}
	
	private User dtoToUser(UserDto dto) {
//		User user=new User();
//		user.setId(dto.getId());
//		user.setName(dto.getName());
//		user.setAbout(dto.getAbout());
//		user.setEmail(dto.getEmail());
//		user.setPassword(dto.getPassword());
		
		User user=this.modelMapper.map(dto, User.class);
		
		return user;
	}
	private UserDto userToDto(User user) {
		UserDto dto=this.modelMapper.map(user, UserDto.class);
		return dto;
	}
}
