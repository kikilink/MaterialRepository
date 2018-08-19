package com.sequoia.mapper;

import com.sequoia.common.PageResult;
import com.sequoia.common.PageVO;
import com.sequoia.domain.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorylistMapper {

	List<Category> getAllCategorylist();

	PageResult<Category> getPagedCategorylist(PageVO pageVO);

	int addCategory(@Param("vo") Category category);
}
