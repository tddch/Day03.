package com.example.day03.fragment1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03.R;
import com.example.day03.adapter.ImageAdapter;
import com.example.day03.bean.ImageBean;
import com.example.day03.pertor.Pertor;
import com.example.day03.view.IView;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment1 extends Fragment implements IView {
    private ArrayList<ImageBean.DataBeanX.DataBean> dataBeans;
    private ImageAdapter imageAdapter;

    public BlankFragment1() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
        initData();
    }

    private void initData() {
        Pertor pertor = new Pertor(this);
        pertor.state();
    }

    private void initView(View view) {
       RecyclerView rec = view.findViewById(R.id.rec);
       rec.setLayoutManager(new LinearLayoutManager(getActivity()));
       rec.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        dataBeans = new ArrayList<>();
        imageAdapter = new ImageAdapter(getActivity(), dataBeans);
        rec.setAdapter(imageAdapter);
    }

    @Override
    public void showYes(Object obj) {
        if(obj instanceof ImageBean){
            ImageBean imageBean= (ImageBean) obj;
            List<ImageBean.DataBeanX.DataBean> data =imageBean.getData().getData();
            dataBeans.addAll(data);
            imageAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showNot(String msg) {

    }
}