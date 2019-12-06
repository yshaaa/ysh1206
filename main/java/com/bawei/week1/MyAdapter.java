package com.bawei.week1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.week1.bean.MyData;
import com.bawei.week1.glide.GlideUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FragmentActivity activity;
    private ArrayList<ShopBean.CardDataBean> list;

    public MyAdapter(FragmentActivity activity, ArrayList<ShopBean.CardDataBean> list) {

        this.activity = activity;
        this.list = list;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = LayoutInflater.from(activity).inflate(R.layout.item, null);
        holder = new OneHolde(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof OneHolde){
            ((OneHolde) holder).total.setText(list.get(position).getTotal());
            ((OneHolde) holder).billdate.setText(list.get(position).getBilldate());
            ((OneHolde) holder).repaydate.setText(list.get(position).getRepaymentdate());
            ((OneHolde) holder).bill.setText(list.get(position).getBill());
            GlideUtil.Loadimage(list.get(position).getImageurl(),((OneHolde) holder).image1);
        }
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (setItemClick != null) {
                            setItemClick.getItemClick(position);
                        }
                    }
                });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class OneHolde extends RecyclerView.ViewHolder {
        @BindView(R.id.image1)
        ImageView image1;
        @BindView(R.id.total)
        TextView total;
        @BindView(R.id.billdate)
        TextView billdate;
        @BindView(R.id.repaydate)
        TextView repaydate;
        @BindView(R.id.bill)
        TextView bill;
        public OneHolde(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface setItemClick{
        void getItemClick(int postion);
    }
    private setItemClick setItemClick;
    public void setSetItemClick(setItemClick setItemClick){
        this.setItemClick=setItemClick;
    }

}
