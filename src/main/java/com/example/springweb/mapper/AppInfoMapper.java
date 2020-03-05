package com.example.springweb.mapper;

import com.example.springweb.dao.AppInfo;
import com.example.springweb.dao.HelloUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppInfoMapper {
    @Select("select * from appinfo ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "classification", column = "classification"),
            @Result(property = "standardslevel", column = "standardslevel"),
            @Result(property = "level", column = "level"),
            @Result(property = "checked", column = "checked")
    })
    List<AppInfo> findAll();

    @Select("select * from appinfo where checked = 0")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "classification", column = "classification"),
            @Result(property = "standardslevel", column = "standardslevel"),
            @Result(property = "level", column = "level"),
            @Result(property = "checked", column = "checked")
    })
    List<AppInfo> findAllUnchecked();

    @Select("select * from appinfo where checked = 1")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "classification", column = "classification"),
            @Result(property = "standardslevel", column = "standardslevel"),
            @Result(property = "level", column = "level"),
            @Result(property = "checked", column = "checked")
    })
    List<AppInfo> findAllchecked();

    @Insert("insert into appinfo(id,name,classification,standardslevel,level,checked) values(#{id},#{name},#{classification},#{standardslevel},#{level},#{checked})")
    void insert(AppInfo appinfo);

    @Update("update appinfo set classification = #{classification}, standardslevel = #{standardslevel}, level = #{level}, checked = #{checked} where id = #{id}")
    void updateByID(AppInfo appinfo);

    @Select("select * from appinfo where id = #{id}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "classification", column = "classification"),
        @Result(property = "standardslevel", column = "standardslevel"),
        @Result(property = "level", column = "level"),
        @Result(property = "checked", column = "checked")
    })
    AppInfo getOne(String id);

    @Select("select count(*) from appinfo ")
    int getCount();

}