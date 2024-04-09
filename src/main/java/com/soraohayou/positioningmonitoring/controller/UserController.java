package com.soraohayou.positioningmonitoring.controller;

import com.soraohayou.positioningmonitoring.entity.User;
import com.soraohayou.positioningmonitoring.exception.CustomException;
import com.soraohayou.positioningmonitoring.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/getAllUser")
    public List<User> getUser() {
        return userService.getUserListByCondition(new HashMap<>());
    }

    @PostMapping("/getAllUserByCondition")
    public List<User> getUserByCondition(String realName, String teamId) {
        Map<String,Object> params = new HashMap<>();
        params.put("realName",realName);
        params.put("teamId",teamId);
        return userService.getUserListByCondition(params);
    }

    @PostMapping("/login")
    public User login(String username, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        User user = userService.getUserByCondition(params);
        if (user == null) {
            return user;
        } else {
            throw new CustomException("用户名密码错误");
        }
    }

    @PostMapping("/register")
    public void register(User userModel) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", userModel.getUserName());
        if (userService.getUserByCondition(params) != null) {
            throw new CustomException("用户名已被注册");
        }
        userService.addUser(userModel);
    }

    @PostMapping("/update")
    public void update(User user) {
        userService.update(user);
    }

    @PostMapping("/delete")
    public void delete(String Id) {
        userService.delete(Id);
    }

}
