package com.example.day03.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day03.App;
import com.example.day03.R;
import com.example.day03.adapter.DAdapter;
import com.example.day03.modle.bean.DbBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DFragment extends Fragment {


    private RecyclerView recycler_d;
    private ArrayList<DbBean> list;
    private DAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_d, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {

        //展示数据，GreenDao查询方法，1.布局。2.适配器
        List<DbBean> dbGrilsBeans = App.daoSession.getDbBeanDao().loadAll();
        list.addAll(dbGrilsBeans);
        adapter.notifyDataSetChanged();
    }

    private void initView(View item) {
        recycler_d = item.findViewById(R.id.recycler_d);


        recycler_d.setLayoutManager(new LinearLayoutManager(getActivity()));

        list = new ArrayList<>();
        adapter = new DAdapter(getActivity(), list);
        recycler_d.setAdapter(adapter);
    }

//
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser){
//            list.clear();
//            initData();
//        }
//    }

}
