package com.yao.mybatis.service;

import com.yao.mybatis.entity.User;
import com.yao.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jack Yao on 2022/2/20 2:30 PM
 */
public interface UserService {
    User getUserById(int id);
    List<User> queryAllUsers();
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(int id);

}
