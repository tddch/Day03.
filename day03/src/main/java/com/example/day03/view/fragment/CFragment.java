package com.example.day03.view.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day03.R;
import com.example.day03.adapter.CAdapter;
import com.example.day03.modle.bean.TextBean;
import com.example.day03.modle.bean.VideoBean;
import com.example.day03.persenter.HomePersenter;
import com.example.day03.view.IView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment implements IView {


    private RecyclerView recycler_c;
    private CAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_c, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        HomePersenter homePersenter = new HomePersenter(this);
        homePersenter.start();
    }

    private void initView(View item) {
        recycler_c  = item.findViewById(R.id.recycler_c);

        recycler_c.setLayoutManager(new LinearLayoutManager(getActivity()));

        recycler_c.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));



        adapter = new CAdapter(getActivity());
        recycler_c.setAdapter(adapter);

    }

    @Override
    public void showdui(Object obj) {
        if (obj instanceof TextBean) {
            List<TextBean.DataBeanX.DataBean> data = ((TextBean) obj).getData().getData();
            adapter.additem(data);
        }
    }

    @Override
    public void showcuo(String msg) {

        Log.e("TAG", "文本页面数据请求失败");
    }
}
