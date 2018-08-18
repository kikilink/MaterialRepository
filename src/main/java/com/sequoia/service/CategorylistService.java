package com.sequoia.service;

import com.sequoia.domain.Category;
import com.sequoia.mapper.CategorylistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorylistService implements ICategorylistService {

	@Autowired
	private CategorylistMapper mapper;

	@Override
	public List<Category> getAllCategorylist() {
		return mapper.getAllCategorylist();
	}

}
