package com.yaozhou.controller;

import com.yaozhou.domain.ResponseResult;
import com.yaozhou.domain.entity.User;
import com.yaozhou.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        return loginService.login(user);
    }


    @PostMapping("/logout")
    public ResponseResult logout() {
        return loginService.logout();
    }


}
