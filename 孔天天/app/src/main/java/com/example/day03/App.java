package com.example.day03;

import android.app.Application;

import com.example.day03.db.DaoMaster;
import com.example.day03.db.DaoSession;

public class App extends Application {
    public static DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper person = new DaoMaster.DevOpenHelper(this, "person");
        daoSession = new DaoMaster(person.getWritableDatabase()).newSession();
    }
}
