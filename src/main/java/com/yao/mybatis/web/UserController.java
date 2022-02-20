package com.yao.mybatis.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yao.mybatis.models.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.Session;
import javax.websocket.server.PathParam;
import java.io.Reader;

/**
 * Created by Jack Yao on 2022/2/19 9:46 PM
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try{
            reader = Resources.getResourceAsReader("config/Configure.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) throws JsonProcessingException {
        SqlSession session = sqlSessionFactory.openSession();
        User user = (User)session.selectOne("com.yao.mybatis.models.UserMapper.GetUserByID",1);
        System.out.println(user.toString());
        System.out.println(new ObjectMapper().writeValueAsString(user));
        return new ObjectMapper().writeValueAsString(user);

    }
}
