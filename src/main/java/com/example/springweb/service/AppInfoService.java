package com.example.springweb.service;

import com.example.springweb.dao.AppInfo;
import com.example.springweb.mapper.AppInfoMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.tags.ParamAware;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AppInfoService {
    @Resource
    public AppInfoMapper appInfoMapper;

    public List<AppInfo> getAllAppInfo() {
        //System.out.println("before find\n\n");
        List<AppInfo> list = appInfoMapper.findAll();
        //System.out.println("after find\n\n");
        return list;
    }

    public List<AppInfo> getAllUncheckedAppInfo() {
        //System.out.println("before find\n\n");
        List<AppInfo> list = appInfoMapper.findAllUnchecked();
        //System.out.println("after find\n\n");
        return list;
    }

    public List<AppInfo> getAllcheckedAppInfo() {
        //System.out.println("before find\n\n");
        List<AppInfo> list = appInfoMapper.findAllchecked();
        //System.out.println("after find\n\n");
        return list;
    }

    public void InsertAppInfo(AppInfo appInfo){
        appInfoMapper.insert(appInfo);
        System.out.println("Afterinsert:"+appInfoMapper.findAll());
    }

    public AppInfo getOne(String id){
        //HelloUser result = new HelloUser();
        AppInfo result = appInfoMapper.getOne(id);
        //System.out.println("getOne:"+result);
        if (result==null)
        {
            result=new AppInfo();//索引为空的时候，返回null，需要这时候对其getId,getName就会出错。
        }
        //System.out.println(result.toString());
        return result;
    }

    public void UpdateAppInfo(AppInfo appInfo){
        appInfoMapper.updateByID(appInfo);
        System.out.println("Afterupdate:"+appInfoMapper.findAll());
    }

    public int getNewid() {
        //System.out.println("before find\n\n");
        int count = appInfoMapper.getCount();
        //System.out.println(count+" after find\n\n");
        return count+1;
    }


}