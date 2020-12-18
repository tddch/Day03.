package com.example.day03;

import android.renderscript.Long2;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Student {
    @Id(autoincrement = true)
    private Long id;
    private String icon;
    private String title;
    private String btn;
    @Generated(hash = 908532029)
    public Student(Long id, String icon, String title, String btn) {
        this.id = id;
        this.icon = icon;
        this.title = title;
        this.btn = btn;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBtn() {
        return this.btn;
    }
    public void setBtn(String btn) {
        this.btn = btn;
    }
}
