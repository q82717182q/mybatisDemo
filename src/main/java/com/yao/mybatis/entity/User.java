package com.yao.mybatis.entity;

import lombok.Data;

/**
 * Created by Jack Yao on 2022/2/19 5:32 PM
 */
@Data
public class User {
    private int id;
    private String name;
    private String dept;
    private String phone;
    private String website;

    public User(int id) {
        this.id = id;
    }
}
