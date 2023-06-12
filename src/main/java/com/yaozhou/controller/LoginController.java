package com.yaozhou.controller;

import com.yaozhou.domain.ResponseResult;
import com.yaozhou.domain.entity.User;
import com.yaozhou.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        return loginService.login(user);
    }

    @GetMapping("/verifyCode")
    public ResponseResult verifyCode() throws IOException {
        return loginService.verifyCode();
    }

    @PostMapping("/logout")
    public ResponseResult logout() {
        return loginService.logout();
    }


}
