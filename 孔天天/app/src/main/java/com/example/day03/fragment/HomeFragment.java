package com.example.day03.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.day03.R;
import com.example.day03.adapter.FragmentVpAdapter;
import com.example.day03.fragment1.BlankFragment1;
import com.example.day03.fragment1.BlankFragment2;
import com.example.day03.fragment1.BlankFragment3;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private TabLayout home_tab;
    private ViewPager home_vp;

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
    }

    private void initView(View view) {
        home_vp = view.findViewById(R.id.home_vp);
        home_tab = view.findViewById(R.id.home_tab);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new BlankFragment1());
        fragments.add(new BlankFragment2());
        fragments.add(new BlankFragment3());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("图片");
        strings.add("视频");
        strings.add("文本");
        FragmentVpAdapter fragmentVpAdapter = new FragmentVpAdapter(getChildFragmentManager(), fragments, strings);
        home_vp.setAdapter(fragmentVpAdapter);
        home_tab.setupWithViewPager(home_vp);
    }
}