package com.example.springweb.service;

import com.example.springweb.controller.UserController;
import com.example.springweb.dao.AppInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springweb.dao.AppInfo;
import com.example.springweb.mapper.AppInfoMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.tags.ParamAware;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppInfoServiceTest {
    @Autowired AppInfoService appInfoService;

    List<AppInfo> t;

    @Test
    public void getAllAppInfo() {
        t=appInfoService.getAllAppInfo();
        for(int i=0;i<t.size();i++)
        {
            System.out.print(t.get(i).getId()+" ");
            System.out.print(t.get(i).getName()+" ");
            System.out.print(t.get(i).getClassification()+" ");
            System.out.print(t.get(i).getStandardslevel()+" ");
            System.out.print(t.get(i).getLevel()+" ");
            System.out.print(t.get(i).getChecked()+" \n");
        }
    }

    @Test
    public void getAllUncheckedAppInfo() {
        t=appInfoService.getAllUncheckedAppInfo();
        for(int i=0;i<t.size();i++)
        {
            System.out.print(t.get(i).getId()+" ");
            System.out.print(t.get(i).getName()+" ");
            System.out.print(t.get(i).getClassification()+" ");
            System.out.print(t.get(i).getStandardslevel()+" ");
            System.out.print(t.get(i).getLevel()+" ");
            System.out.print(t.get(i).getChecked()+" \n");
        }
    }

    @Test
    public void getAllcheckedAppInfo() {
    }

    @Test
    public void insertAppInfo() {
        AppInfo t = new AppInfo();
        t.setId(String.valueOf(appInfoService.getNewid()));
        t.setName("七");
        t.setClassification("第七类");
        t.setStandardslevel("balabala");
        t.setLevel(5);
        t.setChecked(0);
        appInfoService.InsertAppInfo(t);

        AppInfo t2 = new AppInfo();
        t2.setId(String.valueOf(appInfoService.getNewid()));
        t2.setName("八");
        t2.setClassification("第八类");
        t2.setStandardslevel("biubiubibu");
        t2.setLevel(4);
        t2.setChecked(1);
        appInfoService.InsertAppInfo(t2);
    }

    @Test
    public void getOne() {
        AppInfo t = appInfoService.getOne("1");
        System.out.print(t.getId()+" ");
        System.out.print(t.getName()+" ");
        System.out.print(t.getClassification()+" ");
        System.out.print(t.getStandardslevel()+" ");
        System.out.print(t.getLevel()+" ");
        System.out.print(t.getChecked()+" \n");

        AppInfo t2 = appInfoService.getOne("9999");
        System.out.print(t2.getId()+" ");
        System.out.print(t2.getName()+" ");
        System.out.print(t2.getClassification()+" ");
        System.out.print(t2.getStandardslevel()+" ");
        System.out.print(t2.getLevel()+" ");
        System.out.print(t2.getChecked()+" \n");
    }

    @Test
    public void updateAppInfo() {
        AppInfo t = new AppInfo();
        t.setId("1");
        t.setName("九");
        t.setClassification("第九类");
        t.setStandardslevel("balabala");
        t.setLevel(5);
        t.setChecked(0);
        appInfoService.UpdateAppInfo(t);

        AppInfo t2 = new AppInfo();
        t2.setId("9999");
        t2.setName("八");
        t2.setClassification("第八类");
        t2.setStandardslevel("biubiubibu");
        t2.setLevel(4);
        t2.setChecked(1);
        appInfoService.UpdateAppInfo(t2);
    }

    @Test
    public void getNewid() {
       int a = appInfoService.getNewid();
       int b = appInfoService.getNewid();
       System.out.println(a);
       System.out.println(b);
    }
}