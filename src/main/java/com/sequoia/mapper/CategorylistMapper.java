package com.sequoia.mapper;

import com.sequoia.common.PageResult;
import com.sequoia.common.PageVO;
import com.sequoia.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorylistMapper {

	List<Category> getAllCategorylist();

	PageResult<Category> getPagedCategorylist(PageVO pageVO);
}
