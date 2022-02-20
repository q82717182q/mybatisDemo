package com.yao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.Reader;

/**
 * Created by Jack Yao on 2022/2/19 9:40 PM
 */
@SpringBootApplication
@MapperScan("com.yao.mybatis.mapper")
public class MybatisDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);

    }

}
