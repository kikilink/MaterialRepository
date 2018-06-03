package com.newbee.material.repo.api;

import com.newbee.material.repo.domain.User;

public interface IUserService {

    User getUser(String userName);
}
