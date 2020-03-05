package com.example.springweb.controller;


import com.example.springweb.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import com.example.springweb.dao.HelloUser;
import com.example.springweb.mapper.HelloMapper;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller

public class LoginController {
    @Autowired
    HelloService helloService;
    HelloUser helloUser;
    HelloMapper helloMapper;
    //public final static Logger logger = LoggerFactory.getLogger(HelloController.class);
    //Model model;
    //String name;
    //String pw;
    @RequestMapping(value="/index")
    public String login() {
        //跳转到登录的login页面
        
        return "login";
    }

    @RequestMapping(value="/login/verify",method = {RequestMethod.GET, RequestMethod.POST})
	public String verify(String username,String password,Model model,HttpServletRequest request) {
        helloUser = helloService.loginverify(username, password);
        if(helloUser.getId() != null)//matched
        {
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("userid", helloUser.getId());
            return "loginsuccess";
        }
        else
        {
            return "loginfail";
        }
    }

    /*@RequestMapping(value="/showinfo",method = {RequestMethod.GET, RequestMethod.POST})
	public String showinfo(Model model) {
        //model.addAttribute("greeting",userName);

        model.addAttribute("username", name);
        model.addAttribute("password", pw);

        System.out.println("showUsername:\n"+name+"\n");
        System.out.println("showUsername:\n"+pw+"\n");

        return "showinfo";
    }*/

    @RequestMapping(value="/loginsuccess",method = {RequestMethod.GET, RequestMethod.POST})
	public String success(Model model) {
		return "loginsuccess";
    }
    
    @RequestMapping(value="/loginfail",method = {RequestMethod.GET, RequestMethod.POST})
	public String fail(Model model) {
		return "loginfail";
    }

    @RequestMapping(value="/login/login",method = {RequestMethod.GET, RequestMethod.POST})
	public String relogin(Model model) {
		return "login";
    }
}



