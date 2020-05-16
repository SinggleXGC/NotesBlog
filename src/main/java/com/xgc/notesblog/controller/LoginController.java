package com.xgc.notesblog.controller;

import com.xgc.notesblog.Entity.GlobalProperties;
import com.xgc.notesblog.Entity.User;
import com.xgc.notesblog.dto.ResponseDTO;
import com.xgc.notesblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private GlobalProperties globalProperties;

    @PostMapping("/login")
    public ResponseDTO login(@RequestParam String username, @RequestParam String password) {
        ResponseDTO responseDTO = null;
        if (username.equals("") || password.equals("")) {
            return new ResponseDTO(403, "请输入账号或密码", null);
        }
        User user = userService.selectUserByUserName(username);
        if (user == null) {
            responseDTO = new ResponseDTO(403, "用户名不存在", null);
        }else if (!password.equals(user.getPassword())) {
            responseDTO = new ResponseDTO(403, "密码错误", null);
        }else {
            user.setPassword("");
            user.setAvatarUrl(globalProperties.getBaseurl() + user.getAvatarUrl());
            responseDTO = new ResponseDTO(200, "登录成功", user);
        }
        return responseDTO;
    }
}
