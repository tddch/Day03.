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
import com.example.day03.adapter.AAdapter;
import com.example.day03.modle.bean.PicsBean;
import com.example.day03.persenter.HomePersenter;
import com.example.day03.view.IView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements IView {


    private RecyclerView recycler_a;
    private AAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        HomePersenter homePersenter = new HomePersenter(this);
        homePersenter.start();
    }

    private void initView(View item) {
        recycler_a = item.findViewById(R.id.recycler_a);

        recycler_a.setLayoutManager(new LinearLayoutManager(getActivity()));

        recycler_a.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        adapter = new AAdapter(getActivity());
        recycler_a.setAdapter(adapter);

    }

    @Override
    public void showdui(Object obj) {
        if (obj instanceof PicsBean){
            List<PicsBean.DataBeanX.DataBean> data = ((PicsBean) obj).getData().getData();
            adapter.additem(data);
        }
    }

    @Override
    public void showcuo(String msg) {
        Log.e("TAG", "请求失败");
    }
}
