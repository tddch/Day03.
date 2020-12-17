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
import com.example.day03.adapter.EAdapter;
import com.example.day03.modle.bean.ListBean;
import com.example.day03.modle.bean.PicsBean;
import com.example.day03.persenter.HomePersenter;
import com.example.day03.view.IView;

import java.util.List;

public class EFragment extends Fragment implements IView {

    private RecyclerView recycler_e;
    private EAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_e, container, false);
        initVIew(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        HomePersenter homePersenter = new HomePersenter(this);
        homePersenter.start();
    }

    private void initVIew(View item) {
        recycler_e  = item.findViewById(R.id.recycler_e);

        recycler_e.setLayoutManager(new LinearLayoutManager(getActivity()));

        recycler_e.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));


        adapter = new EAdapter(getActivity());
        recycler_e.setAdapter(adapter);
    }

    @Override
    public void showdui(Object obj) {
        if (obj instanceof ListBean){
            List<ListBean.DataBeanX.DataBean> data = ((ListBean) obj).getData().getData();
            adapter.additem(data);
        }
    }

    @Override
    public void showcuo(String msg) {
        Log.e("TAG", "推荐请求失败");
    }
}
