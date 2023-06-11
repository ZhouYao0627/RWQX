package com.yaozhou.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.yaozhou.domain.ResponseResult;
import com.yaozhou.domain.entity.LoginUser;
import com.yaozhou.domain.entity.User;
import com.yaozhou.domain.vo.LoginVo;
import com.yaozhou.domain.vo.UserInfoVo;
import com.yaozhou.enums.AppHttpCodeEnum;
import com.yaozhou.exception.SystemException;
import com.yaozhou.service.LoginService;
import com.yaozhou.utils.BeanCopyUtils;
import com.yaozhou.utils.JwtUtil;
import com.yaozhou.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.yaozhou.constants.SystemConstants.LOGIN_KEY;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 判断是否通过
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }

        // 获取userId 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);

        // 把用户信息存入redis
        redisCache.setCacheObject("login:user" + userId, loginUser);

        // 判断验证码是否正确
        String userCode = user.getCode();
        String code = redisCache.getCacheObject("login:code");
        if (!userCode.equals(code)) {
            throw new SystemException(AppHttpCodeEnum.CODE_ERROR);
        }

        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        LoginVo loginVo = new LoginVo(jwt, userInfoVo);
        return ResponseResult.okResult(loginVo);
    }

    @Override
    public ResponseResult logout() {
        //获取token 解析获取userid
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        //获取userid
        Long userId = loginUser.getUser().getId();
        //删除redis中的用户信息
        redisCache.deleteObject(LOGIN_KEY + userId);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult verifyCode() {
        String code = RandomUtil.randomNumbers(4);
        redisCache.setCacheObject("login:code", code);
        return ResponseResult.okResult(code);
    }
}



















