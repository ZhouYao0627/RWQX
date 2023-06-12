package com.yaozhou.service.impl;

import cn.hutool.core.io.FastByteArrayOutputStream;
import cn.hutool.core.util.RandomUtil;
import com.google.code.kaptcha.Producer;
import com.yaozhou.domain.ResponseResult;
import com.yaozhou.domain.entity.LoginUser;
import com.yaozhou.domain.entity.User;
import com.yaozhou.domain.vo.CodeVo;
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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;

import static com.yaozhou.constants.SystemConstants.*;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private Producer captchaProducer; // kaptcha 生成器

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
        redisCache.setCacheObject(LOGIN_USER_KEY + userId, loginUser);

        // 判断验证码是否正确
        String userCode = user.getCode();
        String code = redisCache.getCacheObject(LOGIN_CODE_KEY);
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
        redisCache.deleteObject(LOGIN_USER_KEY + userId);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult verifyCode() throws IOException {
        String code = RandomUtil.randomString(4);
        redisCache.setCacheObject(LOGIN_CODE_KEY, code);

        // 生成验证码图片
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedImage image = captchaProducer.createImage(code);
        ImageIO.write(image, "jpg", outputStream);

        String codeString = Base64.getEncoder().encodeToString(outputStream.toByteArray());

        return ResponseResult.okResult(codeString);
    }
}



















