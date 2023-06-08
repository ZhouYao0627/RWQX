package com.yaozhou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaozhou.domain.entity.User;
import com.yaozhou.mapper.UserMapper;
import com.yaozhou.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-06-08 14:39:11
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
