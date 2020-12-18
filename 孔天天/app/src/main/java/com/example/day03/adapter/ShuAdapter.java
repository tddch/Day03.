package com.example.day03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day03.R;
import com.example.day03.Student;

import java.util.ArrayList;

public class ShuAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Student> list;

    public ShuAdapter(Context context, ArrayList<Student> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_shujv, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getIcon()).into(viewHolder.image1);
        viewHolder.tv_title1.setText(list.get(position).getTitle());
        viewHolder.btn_an1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image1;
        public TextView tv_title1;
        public Button btn_an1;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image1 = (ImageView) rootView.findViewById(R.id.image1);
            this.tv_title1 = (TextView) rootView.findViewById(R.id.tv_title1);
            this.btn_an1 = (Button) rootView.findViewById(R.id.btn_an1);
        }

    }
}
