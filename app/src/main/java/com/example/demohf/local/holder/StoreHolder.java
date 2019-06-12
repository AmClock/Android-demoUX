package com.example.demohf.local.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demohf.R;

/**
 * @file StoreHolder
 * @author park
 */
public class StoreHolder extends RecyclerView.ViewHolder {

    public TextView no, name, num, regdate;
    public ImageView iv;
    public LinearLayout card;

    /**
     * @name StoreHolder
     * @param itemView - View
     */
    public StoreHolder(@NonNull View itemView) {
        super(itemView);
        no = itemView.findViewById(R.id.tv_no);
        name = itemView.findViewById(R.id.tv_name);
        num = itemView.findViewById(R.id.tv_num);
        regdate = itemView.findViewById(R.id.tv_regdate);
        iv = itemView.findViewById(R.id.iv);
        card = itemView.findViewById(R.id.listTemp);
    }

}
