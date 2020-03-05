package com.example.springweb.controller;


import com.example.springweb.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import com.example.springweb.dao.HelloUser;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {
    @Autowired
    HelloService helloService;
    public final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String hello(Model model){

        logger.info("hello logging" + helloService.getUserList());
        //model.addAttribute("greeting",helloService.getUserList());
        return "hello";
    }

    /*@RequestMapping("/")
    public String login(Model model){

        List<HelloUser> empList = helloService.getUserList();
        //logger.info("hello logging" + helloService.getUserList());
        
        model.addAttribute("empList", empList);
        
        return "login";
    }*/
}
