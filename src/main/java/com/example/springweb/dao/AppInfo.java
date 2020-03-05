package com.example.springweb.dao;

import java.io.Serializable;

public class AppInfo implements Serializable {
    private String id;
    private String name;
    private String classification;
    private String standardslevel;//19 standard's level:1~5
    private int level;//finallevel:1~5
    private int checked; //0:unchecked 1:checked

    public AppInfo(){
        id = null;
        name = null;
        classification = null;
        standardslevel = null;
        level = 0;
        checked = 0;
    }

    public AppInfo(String id,String name,String classification,String standardslevel,int level,int checked)
    {
        this.id = id;
        this.name = name;
        this.classification = classification;
        this.standardslevel = standardslevel;
        this.level = level;
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getStandardslevel() {
        return standardslevel;
    }

    public void setStandardslevel(String standardslevel) {
        this.standardslevel = standardslevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }
}