package com.sequoia.service;

import com.sequoia.domain.Category;

import java.util.List;

public interface ICategorylistService {

    List<Category> getAllCategorylist();

    List<Category> getFirstlevelCategorylist();

    void addCategory(Category category);
}
