package com.soraohayou.positioningmonitoring.service;

import com.soraohayou.positioningmonitoring.dao.UserDao;
import com.soraohayou.positioningmonitoring.entity.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("UserService")
public class UserService {

    @Resource
    private UserDao userDao;

    public List<User> getUserListByCondition(Map<String, Object> params) {
        if (params == null) {
            params = new HashMap<>();
        }
        return userDao.getUserListByCondition(params);
    }

    public User getUserByCondition(Map<String, Object> params) {
        if (params == null) {
            params = new HashMap<>();
        }
        List<User> data = userDao.getUserListByCondition(params);
        return (data == null || data.isEmpty()) ? null : data.get(0);
    }

    /**
     * 增加用户
     */
    public void addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.addUser(user);
    }

    /**
     * 修改
     */
    public void update(User user) {
        userDao.update(user);
    }

    /**
     * 删除
     */
    public void delete(String id) {
        userDao.delete(id);
    }

}
