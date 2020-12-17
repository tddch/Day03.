package com.example.day03.persenter;

import com.example.day03.back.HomeBack;
import com.example.day03.modle.HomeGson;
import com.example.day03.view.IView;

public class HomePersenter {
    private IView view;
    private final HomeGson homeGson;

    public HomePersenter(IView view) {
        this.view = view;
        homeGson = new HomeGson();
    }

    public void start() {
        homeGson.start(new HomeBack() {
            @Override
            public void showdui(Object obj) {
                view.showdui(obj);
            }

            @Override
            public void showcuo(String msg) {
                view.showcuo(msg);
            }
        });
    }
}
