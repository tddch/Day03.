package com.example.day03.pertor;

import com.example.day03.model.Model;
import com.example.day03.recall.ReCall;
import com.example.day03.view.IView;

public class Pertor {
    private IView iView;
    private Model model;

    public Pertor(IView iView) {
        this.iView = iView;
        model=new Model();
    }

    public void state() {
        model.getData(new ReCall() {
            @Override
            public void showOk(Object obj) {
                iView.showYes(obj);
            }

            @Override
            public void showNo(String msg) {
                iView.showNot(msg);
            }
        });
    }
}
