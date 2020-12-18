package com.example.day03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day03.App;
import com.example.day03.R;
import com.example.day03.modle.bean.DbBean;
import com.example.day03.modle.bean.ListBean;

import java.util.ArrayList;
import java.util.List;

public class EAdapter extends RecyclerView.Adapter<EAdapter.ViewHolder> {
    private Context context;
    private List<ListBean.DataBeanX.DataBean> list = new ArrayList<>();

    public void additem(List<ListBean.DataBeanX.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public EAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.list_item, null, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final ListBean.DataBeanX.DataBean dataBean = list.get(position);
        holder.name.setText(dataBean.getTitle());
        holder.text.setText(dataBean.getIntro());

        Glide.with(context).load(dataBean.getIcon()).into(holder.img);

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.btn.setText("已关注");

                DbBean bean = new DbBean();
                bean.setPicimg(dataBean.getIcon());
                bean.setName(dataBean.getTitle());
                bean.setText(dataBean.getIntro());

                long insert = App.daoSession.getDbBeanDao().insert(bean);


                if (insert>0){
                    Toast.makeText(context, "收藏成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "收藏失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView text;
        Button btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.list_img);
            name = itemView.findViewById(R.id.list_name);
            text = itemView.findViewById(R.id.list_text);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}
