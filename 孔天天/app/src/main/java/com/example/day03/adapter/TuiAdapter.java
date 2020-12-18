package com.example.day03.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day03.App;
import com.example.day03.R;
import com.example.day03.Student;
import com.example.day03.bean.TuiBean;
import com.example.day03.db.StudentDao;

import java.util.ArrayList;

public class TuiAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<TuiBean.DataBeanX.DataBean> list;
    private ImageView image;
    private TextView tv_title;
    private TextView tv_count;
    private Button btn_an;
    private StudentDao studentDao;

    public TuiAdapter(Context context, ArrayList<TuiBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_tui, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getIcon()).into(viewHolder.image);
        viewHolder.tv_title.setText(list.get(position).getTitle());
        studentDao = App.daoSession.getStudentDao();

        viewHolder.btn_an.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.btn_an.setText("已收藏");
                Student student = new Student();
                student.setIcon(list.get(position).getIcon());
                student.setTitle(list.get(position).getTitle());
                long insert = studentDao.insert(student);
                if(insert != 0){
                    Log.e("TAH","成功");
                }{
                    Log.e("TAH","失败");
                }
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
        public ImageView image;
        public TextView tv_title;
        public TextView tv_count;
        public Button btn_an;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image = (ImageView) rootView.findViewById(R.id.image);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_count = (TextView) rootView.findViewById(R.id.tv_count);
            this.btn_an = (Button) rootView.findViewById(R.id.btn_an);
        }

    }
}
