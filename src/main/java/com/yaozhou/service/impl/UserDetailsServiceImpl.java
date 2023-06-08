package com.yaozhou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yaozhou.domain.entity.LoginUser;
import com.yaozhou.domain.entity.User;
import com.yaozhou.enums.AppHttpCodeEnum;
import com.yaozhou.exception.SystemException;
import com.yaozhou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        User user = userService.getOne(queryWrapper);
        if (Objects.isNull(user)) {
            throw new SystemException(AppHttpCodeEnum.LOGIN_ERROR);
        }

        return new LoginUser(user);
    }
}
