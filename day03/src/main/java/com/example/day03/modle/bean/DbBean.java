package com.example.day03.modle.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbBean {

    @Id(autoincrement = true)
    private Long id;
    private String picimg;
    private String name;
    private String text;
    @Generated(hash = 487520079)
    public DbBean(Long id, String picimg, String name, String text) {
        this.id = id;
        this.picimg = picimg;
        this.name = name;
        this.text = text;
    }
    @Generated(hash = 1953169116)
    public DbBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPicimg() {
        return this.picimg;
    }
    public void setPicimg(String picimg) {
        this.picimg = picimg;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }

}
