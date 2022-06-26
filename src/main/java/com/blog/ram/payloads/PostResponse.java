package com.blog.ram.payloads;

import java.util.List;

public class PostResponse {
	
	private List<PostDto>contentDtos;
	private int pageNumber;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean lastPage;
	
	public PostResponse() {	}

	public PostResponse(List<PostDto> contentDtos, int pageNumber, int pageSize, long totalElements, int totalPages,
			boolean lastPage) {
		super();
		this.contentDtos = contentDtos;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.lastPage = lastPage;
	}

	public List<PostDto> getContentDtos() {
		return contentDtos;
	}

	public void setContentDtos(List<PostDto> contentDtos) {
		this.contentDtos = contentDtos;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	

}
