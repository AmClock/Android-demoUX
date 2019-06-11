package com.example.demohf.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.demohf.R;
import com.example.demohf.contract.TitleContract;

public class TitleView extends AppCompatActivity implements TitleContract.TitleView  , View.OnClickListener {

    private Integer[] btnId = {R.id.goJoinBtn , R.id.goLoginBtn};
    private Button[] btnArry = new Button[2];
    private String TAG = "TITLE_VIEW";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_title);
        init();
    }

    @Override
    public void init() {
        for(int i = 0 ; i < btnId.length ; i++){
            btnArry[i] = (Button)findViewById(btnId[i]);
            btnArry[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this ,
                v.getId() == R.id.goLoginBtn ? LoginView.class : JoinView.class
                ));
        finish();
    }

}
