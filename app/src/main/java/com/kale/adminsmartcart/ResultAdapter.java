package com.kale.adminsmartcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.MyViewHolder> {

    Context context;
    List<ResultModel> resultModels;

    public ResultAdapter(Context context, List<ResultModel> resultModels) {
        this.context = context;
        this.resultModels = resultModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.resultitem,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultAdapter.MyViewHolder holder, int position) {

        ResultModel pos = resultModels.get(position);
        holder.pro_name.setText(pos.getProduct_name());
        holder.pro_price.setText(pos.getProduct_price());

        Glide.with(context)
                .load(pos.getProduct_img())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.pro_img);

    }

    @Override
    public int getItemCount() {
        return resultModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView pro_name,pro_price;
        ImageView pro_img;
        public MyViewHolder(View itemView) {
            super(itemView);
            pro_img = itemView.findViewById(R.id.pro_img);
            pro_name = itemView.findViewById(R.id.pro_name);
            pro_price = itemView.findViewById(R.id.pro_price);
        }
    }
}
