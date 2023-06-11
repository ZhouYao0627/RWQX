package com.yaozhou.service;

import com.yaozhou.domain.ResponseResult;
import com.yaozhou.domain.entity.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();

    ResponseResult verifyCode();
}
