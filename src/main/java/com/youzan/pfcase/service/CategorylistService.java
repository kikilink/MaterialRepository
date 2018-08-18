package com.youzan.pfcase.service;

import com.youzan.pfcase.domain.Category;
import com.youzan.pfcase.mapper.CategorylistMapper;
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
