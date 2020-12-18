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
import com.example.day03.db.DbBeanDao;
import com.example.day03.modle.bean.DbBean;

import java.util.ArrayList;

public class DAdapter extends RecyclerView.Adapter<DAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DbBean> list;

    public DAdapter(Context context, ArrayList<DbBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.list_item, null, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        DbBean bean = list.get(position);
        holder.name.setText(bean.getName());
        holder.text.setText(bean.getText());

        Glide.with(context).load(bean.getPicimg()).into(holder.img);

        final DbBeanDao dbBeanDao = App.daoSession.getDbBeanDao();

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbBeanDao.delete(list.get(position));
                Toast.makeText(context, "取消收藏", Toast.LENGTH_SHORT).show();
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
