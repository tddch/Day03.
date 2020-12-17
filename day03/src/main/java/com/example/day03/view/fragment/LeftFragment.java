package com.example.day03.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.day03.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {


    private TabLayout tabalyout_left;
    private ViewPager viewpager_left;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_left, container, false);
        initView(inflate);
        return inflate;
    }


    private void initView(View item) {
        tabalyout_left  = item.findViewById(R.id.tabalyout_left);
        viewpager_left  = item.findViewById(R.id.viewpager_left);

        final List<Fragment> fragments = new ArrayList<>();

        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());

        viewpager_left.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        tabalyout_left.setupWithViewPager(viewpager_left);

        tabalyout_left.getTabAt(0).setText("图片");
        tabalyout_left.getTabAt(1).setText("视频");
        tabalyout_left.getTabAt(2).setText("文本");

    }

}
