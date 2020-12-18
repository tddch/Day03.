package com.example.day03;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day03.adapter.FragmentVpAdapter;
import com.example.day03.fragment.BlankFragment;
import com.example.day03.fragment.CallFragment;
import com.example.day03.fragment.HomeFragment;
import com.example.day03.fragment.ShowFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CallFragment());
        fragments.add(new BlankFragment());
        fragments.add(new ShowFragment());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("首页");
        strings.add("沙发");
        strings.add("发现");
        strings.add("我的");
        FragmentVpAdapter fragmentVpAdapter = new FragmentVpAdapter(getSupportFragmentManager(), fragments, strings);
        vp.setAdapter(fragmentVpAdapter);
        tab.setupWithViewPager(vp);
    }
}