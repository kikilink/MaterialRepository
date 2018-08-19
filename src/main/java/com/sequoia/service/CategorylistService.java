package com.sequoia.service;

import com.sequoia.domain.Category;
import com.sequoia.domain.UserDetails;
import com.sequoia.mapper.CategorylistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@Override
	public void addCategory(Category category) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String currentUser = userDetails.getUsername();
		category.setCreator(currentUser);
		category.setLastUpdator(currentUser);
		mapper.addCategory(category);
	}

}
