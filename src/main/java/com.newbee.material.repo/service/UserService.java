package com.newbee.material.repo.service;

import com.newbee.material.repo.api.IUserService;
import com.newbee.material.repo.dao.IUserDao;
import com.newbee.material.repo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public User getUser(String userName) {
		return userDao.getUser(userName);
	}
}
