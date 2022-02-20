package com.yao.mybatis.mapper;

import com.yao.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Jack Yao on 2022/2/19 6:17 PM
 */
@Mapper
public interface UserMapper {
    User getUserById(int id);
    List<User> queryAllUsers();
}
