package com.example.springweb.service;

import com.example.springweb.dao.HelloUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springweb.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.example.springweb.dao.HelloUser;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {
    @Autowired
    HelloService helloService;
    HelloUser helloUser;

    @Test
    public void getUserList() {
    }

    @Test
    public void insertUser() {
    }

    @Test
    public void getOne() {
    }

    @Test
    public void loginverify() {
        HelloUser t1 = helloService.loginverify("wang","1234");
        if(t1.getId()!=null)
        {
            System.out.println("密码正确");
            System.out.println("loginverify:"+t1);
        }
        else
        {
            System.out.println("密码错误");
        }
        System.out.println();
        HelloUser t2 = helloService.loginverify("wang","4321");
        if(t2.getId()!=null)
        {
            System.out.println("密码正确");
            System.out.println("loginverify:"+t2);
        }
        else
        {
            System.out.println("密码错误");
        }
    }

    @Test
    public void updateByID() {
    }

    @Test
    public void deleteByID() {
    }
}