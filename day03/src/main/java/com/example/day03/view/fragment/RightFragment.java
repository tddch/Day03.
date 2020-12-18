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
public class RightFragment extends Fragment {


    private TabLayout tabalyout_right;
    private ViewPager viewpager_right;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_right, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View item) {
        tabalyout_right = item.findViewById(R.id.tabalyout_right);
        viewpager_right = item.findViewById(R.id.viewpager_right);


        final List<Fragment> fragments = new ArrayList<>();

        fragments.add(new DFragment());
        fragments.add(new EFragment());

        viewpager_right.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        tabalyout_right.setupWithViewPager(viewpager_right);

        tabalyout_right.getTabAt(0).setText("关注");
        tabalyout_right.getTabAt(1).setText("推荐");

    }

}
