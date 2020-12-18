package com.example.day03.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.day03.R;
import com.example.day03.adapter.FragmentVpAdapter;
import com.example.day03.fragment1.HomeFragment1;
import com.example.day03.fragment1.HomeFragment2;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class BlankFragment extends Fragment {
    public BlankFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
    }

    private void initView(View view) {
        TabLayout tab= view.findViewById(R.id.blank_tab);
        ViewPager vp = view.findViewById(R.id.blank_vp);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment1());
        fragments.add(new HomeFragment2());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("关注");
        strings.add("推荐");
        FragmentVpAdapter fragmentVpAdapter = new FragmentVpAdapter(getChildFragmentManager(), fragments, strings);
        vp.setAdapter(fragmentVpAdapter);
        tab.setupWithViewPager(vp);
    }
}