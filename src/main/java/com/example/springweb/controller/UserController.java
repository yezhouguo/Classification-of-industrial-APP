package com.example.springweb.controller;


import com.example.springweb.service.AppInfoService;
import com.example.springweb.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import com.example.springweb.dao.AppInfo;
import com.example.springweb.dao.HelloUser;
import com.example.springweb.mapper.HelloMapper;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.String;

@Controller

public class UserController {
    @Autowired
    public AppInfoService appInfoService;

    String userid;
    String username;
    //List<AppInfo> appInfoList;
    
    @RequestMapping(value="/userindex", method = {RequestMethod.GET, RequestMethod.POST})
    public String userindex(Model model,HttpServletRequest request)
    {
        
        userid=(String)request.getSession().getAttribute("userid");
        username=(String)request.getSession().getAttribute("username");

        model.addAttribute("userid", userid);
        model.addAttribute("username", username);
        
        
        //System.out.println("userindex\n\n");

        List<AppInfo> appInfoList = appInfoService.getAllUncheckedAppInfo();
        List<AppInfo> checkedappInfoList = appInfoService.getAllcheckedAppInfo();

        //model.addAttribute("standardslevel1", appInfoList.get(1).);

        model.addAttribute("appInfoList", appInfoList);
        model.addAttribute("checkedappInfoList", checkedappInfoList);

        return "userindex";
    }

    @RequestMapping(value="/addApp", method = {RequestMethod.GET, RequestMethod.POST})
    public String addApp(String name,String classification,String standardslevel,String level,String checked,Model model,HttpServletRequest request) 
    {
        return "addApp";
    }

    @RequestMapping(value="/userindex/addApp", method = {RequestMethod.GET, RequestMethod.POST})
    public String addAppInfo(String name,String classification,String standardslevel,String stringlevel,String stringchecked,Model model,HttpServletRequest request) 
    {
        int temp = appInfoService.getNewid();
        String id = String.valueOf(temp);
        System.out.println(temp);
        int level =0;
        int checked=0;
        if(stringlevel != null)
        {
            level = Integer.parseInt(stringlevel);
        }
        if(stringchecked != null)
        {
            checked = Integer.parseInt(stringchecked);
        }
        
        AppInfo appInfo = new AppInfo(id,name,classification,standardslevel,level,checked);
        appInfoService.InsertAppInfo(appInfo);

        System.out.println("name:\n"+id+"\n");
        System.out.println("name:\n"+name+"\n");
        System.out.println("classification:\n"+classification+"\n");
        System.out.println("standardslevel:\n"+standardslevel+"\n");
        System.out.println("level:\n"+level+"\n");
        System.out.println("checked:\n"+checked+"\n");

        userid=(String)request.getSession().getAttribute("userid");
        username=(String)request.getSession().getAttribute("username");

        model.addAttribute("userid", userid);
        model.addAttribute("username", username);

        List<AppInfo> appInfoList = appInfoService.getAllUncheckedAppInfo();
        List<AppInfo> checkedappInfoList = appInfoService.getAllcheckedAppInfo();


        model.addAttribute("appInfoList", appInfoList);
        model.addAttribute("checkedappInfoList", checkedappInfoList);

        return "addAppsuccess";
    }

    

    @RequestMapping(value="/addAppsuccess",method = {RequestMethod.GET, RequestMethod.POST})
	public String success(Model model) {
		return "addAppsuccess";
    }
    
    @RequestMapping(value="/checkApp", method = {RequestMethod.GET, RequestMethod.POST})
    public String checkApp(String name,String classification,String standardslevel,String level,String checked,Model model,HttpServletRequest request) 
    {
        List<AppInfo> appInfoList = appInfoService.getAllUncheckedAppInfo();
        model.addAttribute("appInfoList", appInfoList);
        return "checkApp";
    }

    @RequestMapping(value="/userindex/checkApp", method = {RequestMethod.GET, RequestMethod.POST})
    public String checkAppInfo(String id,Model model,HttpServletRequest request) 
    {
        
        request.getSession().setAttribute("checkid", id);
        

        model.addAttribute("appInfo.id", id);
        AppInfo appInfo = appInfoService.getOne(id);

        request.getSession().setAttribute("checkAppInfo", appInfo);

        List<AppInfo> appInfoList = new ArrayList<AppInfo>();
        appInfoList.add(appInfo);
        model.addAttribute("appInfoList", appInfoList);

        return "checkAppById";
    }

    @RequestMapping(value="/userindex/checkApp/checkAppById", method = {RequestMethod.GET, RequestMethod.POST})
    public String checkAppById(String standardslevel,String stringlevel,String stringchecked,Model model,HttpServletRequest request) 
    {
        AppInfo appInfo = (AppInfo)request.getSession().getAttribute("checkAppInfo");
        
        int level=0;
        int checked=0;
        if(stringlevel != null)
        {
            level = Integer.parseInt(stringlevel);
        }
        if(stringchecked != null)
        {
            checked = Integer.parseInt(stringchecked);
        }
        //System.out.println("checkAppById:\n"+id+"\n");
        appInfo.setStandardslevel(standardslevel);
        appInfo.setLevel(level);
        appInfo.setChecked(checked);

        appInfoService.UpdateAppInfo(appInfo);

        userid=(String)request.getSession().getAttribute("userid");
        username=(String)request.getSession().getAttribute("username");

        model.addAttribute("userid", userid);
        model.addAttribute("username", username);

        List<AppInfo> appInfoList = appInfoService.getAllUncheckedAppInfo();
        List<AppInfo> checkedappInfoList = appInfoService.getAllcheckedAppInfo();


        model.addAttribute("appInfoList", appInfoList);
        model.addAttribute("checkedappInfoList", checkedappInfoList);


        return "checkAppsuccess";
    }

}