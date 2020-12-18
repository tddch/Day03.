package com.example.day03.fragment1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03.App;
import com.example.day03.R;
import com.example.day03.Student;
import com.example.day03.adapter.ShuAdapter;
import com.example.day03.adapter.TuiAdapter;
import com.example.day03.db.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment1 extends Fragment {

    private ArrayList<Student> students1;
    private ShuAdapter shuAdapter;

    public HomeFragment1() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false);
    }
    private void initData() {
        StudentDao studentDao = App.daoSession.getStudentDao();
        List<Student> students = studentDao.loadAll();
        students1.addAll(students);
        shuAdapter.notifyDataSetChanged();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
    }

    private void initView(View view) {
        RecyclerView rec = view.findViewById(R.id.reay_home);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        students1 = new ArrayList<>();
        shuAdapter = new ShuAdapter(getActivity(), students1);
        rec.setAdapter(shuAdapter);
        initData();
    }
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if(!isVisibleToUser){
//            initData();
//        }
//    }
}