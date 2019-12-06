package com.bawei.week1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.week1.R;
import com.bawei.week1.bean.MyData;
import com.bawei.week1.glide.GlideUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FragmentActivity activity;
    private ArrayList<MyData.ResultBean> list;

    public UAdapter(FragmentActivity activity, ArrayList<MyData.ResultBean> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = LayoutInflater.from(activity).inflate(R.layout.item1, null);
        holder = new OneHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof OneHolder){
            GlideUtil.Loadimage(list.get(position).getImageUrl(),((OneHolder) holder).imageview);
            ((OneHolder) holder).title.setText(list.get(position).getTitle());
            ((OneHolder) holder).rank.setText(list.get(position).getRank()+"");
            ((OneHolder) holder).arg.setText(list.get(position).getRank()+"");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class OneHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageview)
        ImageView imageview;
        @BindView(R.id.rank)
        TextView rank;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.arg)
        TextView arg;
        public OneHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
