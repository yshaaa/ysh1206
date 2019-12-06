package com.bawei.week1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.week1.R;
import com.bawei.week1.bean.Bean1205;
import com.bawei.week1.glide.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter1205 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final Context context;
    private final List<Bean1205.ResultBean> list;

    public MyAdapter1205(Context context, List<Bean1205.ResultBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = LayoutInflater.from(context).inflate(R.layout.item12051, null);
        holder = new oneHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof oneHolder){
            GlideUtil.Loadimage(list.get(position).getImageUrl(),((oneHolder) holder).image);
            ((oneHolder) holder).title.setText(list.get(position).getTitle());
            ((oneHolder) holder).rank.setText(list.get(position).getRank()+"");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class oneHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.rank)
        TextView rank;
        @BindView(R.id.arg)
        TextView arg;
        public oneHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
