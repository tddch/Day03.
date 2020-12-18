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
import com.example.day03.modle.bean.PicsBean;

import java.util.ArrayList;
import java.util.List;

public class AAdapter extends RecyclerView.Adapter<AAdapter.ViewHolder> {

    private Context context;
    private List<PicsBean.DataBeanX.DataBean> list = new ArrayList<>();

    public void additem(List<PicsBean.DataBeanX.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public AAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.recy_item, null, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PicsBean.DataBeanX.DataBean dataBean = list.get(position);
        //feeds_text : 看世界在等着我们
        //activityText : 多彩生活
        holder.title.setText(dataBean.getActivityText());
        holder.text.setText(dataBean.getFeeds_text());
        Glide.with(context).load(dataBean.getCover()).into(holder.img);
        RequestOptions options = new RequestOptions();
        options.circleCrop();
        Glide.with(context).load(R.mipmap.a4).apply(options).into(holder.img1);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView text;
        ImageView img;
        ImageView img1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.recy_text);
            title = itemView.findViewById(R.id.recy_title);
            img = itemView.findViewById(R.id.recy_big_img);
            img1 = itemView.findViewById(R.id.recy_tou);
        }
    }
}
