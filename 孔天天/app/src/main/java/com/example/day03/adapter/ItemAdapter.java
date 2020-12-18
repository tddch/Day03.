package com.example.day03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day03.R;
import com.example.day03.bean.ItemBean;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ItemBean.DataBeanX.DataBean> list;

    public ItemAdapter(Context context, ArrayList<ItemBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_shi, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getUrl()).into(viewHolder.shi_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView shi_image;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.shi_image = (ImageView) rootView.findViewById(R.id.shi_image);
        }

    }
}
