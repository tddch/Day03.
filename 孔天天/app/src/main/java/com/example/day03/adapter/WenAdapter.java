package com.example.day03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day03.R;
import com.example.day03.bean.WenBean;

import java.util.ArrayList;

public class WenAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<WenBean.DataBeanX.DataBean> list;

    public WenAdapter(Context context, ArrayList<WenBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_wen, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
     ViewHolder viewHolder= (ViewHolder) holder;
        WenBean.DataBeanX.DataBean dataBean = list.get(position);
        Glide.with(context).load(dataBean.getAuthor().getAvatar()).into(viewHolder.iamge);
        viewHolder.tev.setText(dataBean.getAuthor().getName());
        viewHolder.count.setText(dataBean.getAuthor().getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iamge;
        public TextView tev;
        public TextView count;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iamge = (ImageView) rootView.findViewById(R.id.iamge);
            this.tev = (TextView) rootView.findViewById(R.id.tev);
            this.count = (TextView) rootView.findViewById(R.id.count);
        }

    }
}
