package com.youzan.pfcase.mapper;

import com.youzan.pfcase.common.PageResult;
import com.youzan.pfcase.common.PageVO;
import com.youzan.pfcase.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorylistMapper {

	List<Category> getAllCategorylist();

	PageResult<Category> getPagedCategorylist(PageVO pageVO);
}
