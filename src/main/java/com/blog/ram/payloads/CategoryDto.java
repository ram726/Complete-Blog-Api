package com.blog.ram.payloads;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	private Integer categoryIdInteger;
	
	@NotBlank
	@Size(min = 5,message = "category title must have 5 characters.")
	private String categoryTitle;
	@NotBlank
	@Size(min = 10,message = "category description must have 10 characters.")
	private String categoryDescription;

}
