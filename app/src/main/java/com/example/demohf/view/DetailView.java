package com.example.demohf.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demohf.R;
import com.example.demohf.contract.DetailContract;
import com.example.demohf.local.vo.Store;
import com.example.demohf.presenter.DetailPreseneter;

/**
 * @file DetailView.java
 * @author park
 */
public class DetailView extends AppCompatActivity implements DetailContract.DetailView {

    private String TAG = "DETAIL_VIEW";
    private Integer[] dtId = {R.id.dt_no,R.id.dt_name,R.id.dt_num,R.id.dt_regdate};
    private ImageView iv;
    private DetailContract.DetailPresenter presenter;

    private TextView[] tvArry = new TextView[3];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_detail);
    }//onCreate end

    @Override
    public void init() {

        presenter = new DetailPreseneter(this);
        Store store = presenter.showDetail(new Intent().getIntExtra("no" , 0));

        for (int i = 0 ; i < dtId.length ; i++){
            tvArry[i] = (TextView)findViewById(dtId[i]);
        }
        iv = (ImageView) findViewById(R.id.dt_iv);

        if(store != null) {
            tvArry[0].setText(String.valueOf(store.getNo()));
            tvArry[1].setText(store.getName());
            tvArry[2].setText(String.valueOf(store.getNum()));
            tvArry[3].setText(String.valueOf(store.getRegdate()));
            iv.setImageBitmap(store.getImage());
        }

    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this,msg+"_ERROR",Toast.LENGTH_LONG).show();
    }
}//DetailView end
