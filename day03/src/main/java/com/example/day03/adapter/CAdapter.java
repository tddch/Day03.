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
import com.bumptech.glide.request.RequestOptions;
import com.example.day03.R;
import com.example.day03.modle.bean.TextBean;

import java.util.ArrayList;
import java.util.List;

public class CAdapter extends RecyclerView.Adapter<CAdapter.ViewHolder> {
    private Context context;
    private List<TextBean.DataBeanX.DataBean>list =new ArrayList<>();

    public void additem(List<TextBean.DataBeanX.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public CAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.text_item, null, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextBean.DataBeanX.DataBean dataBean = list.get(position);


        holder.title.setText(dataBean.getAuthor().getName());
        holder.text.setText(dataBean.getAuthor().getName());
        RequestOptions options = new RequestOptions();
        options.circleCrop();
        Glide.with(context).load(R.mipmap.a4).apply(options).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        TextView title;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text_text);
            img = itemView.findViewById(R.id.text_tou);
            title = itemView.findViewById(R.id.text_title);
        }
    }
}
