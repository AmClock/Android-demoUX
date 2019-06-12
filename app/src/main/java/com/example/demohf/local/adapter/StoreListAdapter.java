package com.example.demohf.local.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demohf.R;
import com.example.demohf.local.holder.StoreHolder;
import com.example.demohf.local.vo.Store;
import com.example.demohf.view.DetailView;

import java.util.ArrayList;

/**
 * @file StoreListAdapter.java
 * @author park
 */
public class StoreListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Store> list;

    /**
     * @name StoreListAdapter
     * @param list - ArrayList<Store>
     * add data
     */
    public StoreListAdapter(ArrayList<Store> list){
        this.list = list;
        notifyDataSetChanged();
    }

    /**
     * onCreateViewHolder
     * @param viewGroup
     * @param i - int
     * @return RecyclerView.ViewHolder
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.store_list,viewGroup,false);
        return new StoreHolder(v);
    }

    /**
     * @name onBindViewHolder
     * @param viewHolder - RecyclerView.ViewHolder
     * @param i - int
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder,final int i) {
        StoreHolder holder = (StoreHolder) viewHolder;
        holder.no.setText(String.valueOf(list.get(i).getNo()));
        holder.name.setText(list.get(i).getName());
        holder.num.setText(String.valueOf(list.get(i).getNum()));
        holder.regdate.setText(String.valueOf(list.get(i).getRegdate()));

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context , DetailView.class);
                intent.putExtra("no" , list.get(i).getNo());
                context.startActivity(intent);
            }
        });
    }

    /**
     * @name getItemCount
     * @return int
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

}
