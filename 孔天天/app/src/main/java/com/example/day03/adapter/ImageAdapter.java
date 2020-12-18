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
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.day03.R;
import com.example.day03.bean.ImageBean;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ImageBean.DataBeanX.DataBean> list;

    public ImageAdapter(Context context, ArrayList<ImageBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_item, parent, false);
        return new ViewHolder(inflate){
        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getAuthor().getAvatar())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(viewHolder.tou_image);
        viewHolder.tou_title.setText(list.get(position).getAuthor().getName());
        viewHolder.title.setText(list.get(position).getFeeds_text());
        Glide.with(context).load(list.get(position).getCover()).into(viewHolder.tu_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView tou_image;
        public TextView tou_title;
        public TextView title;
        public ImageView tu_image;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tou_image = (ImageView) rootView.findViewById(R.id.tou_image);
            this.tou_title = (TextView) rootView.findViewById(R.id.tou_title);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.tu_image = (ImageView) rootView.findViewById(R.id.tu_image);
        }

    }
}
