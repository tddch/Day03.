package com.example.day03;

import android.app.Application;

import com.example.day03.db.DaoMaster;
import com.example.day03.db.DaoSession;

import java.util.HashMap;

public class App extends Application {

    public static DaoSession daoSession;
    public static HashMap<String, Object> map;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this,"person");
        daoSession=  new DaoMaster(devOpenHelper.getWritableDatabase()).newSession();
        map=new HashMap<>();


    }
}
