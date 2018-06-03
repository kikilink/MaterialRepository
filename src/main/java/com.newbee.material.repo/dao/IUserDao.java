package com.newbee.material.repo.dao;

import com.newbee.material.repo.domain.User;
import org.apache.ibatis.annotations.Param;

public interface IUserDao {

	User getUser(@Param("userName") String userName);
}
