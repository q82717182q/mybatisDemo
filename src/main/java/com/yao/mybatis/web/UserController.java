package com.yao.mybatis.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yao.mybatis.entity.User;
import com.yao.mybatis.mapper.UserMapper;
import com.yao.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jack Yao on 2022/2/19 9:46 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id) throws JsonProcessingException {
        User user = userService.getUserById(id);
        System.out.println(user);
        System.out.println(new ObjectMapper().writeValueAsString(user));
        return new ObjectMapper().writeValueAsString(user);
    }

    @GetMapping("")
    public String queryAllUsers() throws JsonProcessingException {
        List<User> user = userService.queryAllUsers();
        System.out.println(user);
        System.out.println(new ObjectMapper().writeValueAsString(user));
        return new ObjectMapper().writeValueAsString(user);
    }

    @PostMapping("/insert")
    public String insertUser(@RequestBody User user){
        System.out.println(user.toString());
        String dept = user.getDept();
        userService.insertUser(user);

        return "insert success";
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        System.out.println(user.toString());
        userService.updateUser(user);
        return "update success";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        System.out.println("id : " + id);
        userService.deleteUser(id);
        return "delete success";
    }



}
