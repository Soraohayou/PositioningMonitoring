package com.soraohayou.positioningmonitoring.dao;

import com.soraohayou.positioningmonitoring.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

    List<User> getUserListByCondition(Map<String, Object> params);

    void addUser(User user);

    void update(User user);

    void delete(String id);

}
