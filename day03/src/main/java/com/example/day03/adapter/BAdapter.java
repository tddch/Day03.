package com.example.day03.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day03.R;
import com.example.day03.modle.bean.VideoBean;

import java.util.ArrayList;
import java.util.List;

public class BAdapter extends RecyclerView.Adapter<BAdapter.ViewHolder> {

    private Context contextl;
    private VideoView video;
    private List<VideoBean.DataBeanX.DataBean> list = new ArrayList<>();

    public void additem(List<VideoBean.DataBeanX.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public BAdapter(Context contextl) {
        this.contextl = contextl;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(contextl).inflate(R.layout.video_item, null, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoBean.DataBeanX.DataBean dataBean = list.get(position);

        holder.title.setText(dataBean.getAuthor().getName());
        holder.text.setText(dataBean.getAuthor().getName());
        RequestOptions options = new RequestOptions();
        options.circleCrop();
        Glide.with(contextl).load(R.mipmap.a4).apply(options).into(holder.img);


        Uri parse = Uri.parse(dataBean.getUrl());
        video.setVideoURI(parse);
        MediaController mediaController = new MediaController(contextl);
        video.setMediaController(mediaController);
        mediaController.setPrevNextListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "下一个");
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "下一个");
            }
        });

        video.start();

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
            text = itemView.findViewById(R.id.video_text);
            img = itemView.findViewById(R.id.vieo_tou);
            title = itemView.findViewById(R.id.video_title);
            video = itemView.findViewById(R.id.video_video);
        }
    }
}
