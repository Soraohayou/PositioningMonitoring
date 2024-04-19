package com.soraohayou.positioningmonitoring.controller.web;

import com.soraohayou.positioningmonitoring.entity.User;
import com.soraohayou.positioningmonitoring.exception.CustomException;
import com.soraohayou.positioningmonitoring.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/getAllUser")
    @ResponseBody
    public List<User> getAllUser() {
        return userService.getUserListByCondition(new HashMap<>());
    }

    @PostMapping("/getAllUserByCondition")
    @ResponseBody
    public List<User> getUserByCondition(String realName, String teamId) {
        Map<String, Object> params = new HashMap<>();
        params.put("realName", realName);
        params.put("teamId", teamId);
        return userService.getUserListByCondition(params);
    }

    @PostMapping("/login")
    @ResponseBody
    public User login(String username, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        User user = userService.getUserByCondition(params);
        if (user != null) {
            return user;
        } else {
            throw new CustomException("用户名密码错误");
        }
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "/login";
    }

    @PostMapping("/register")
    @ResponseBody
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
