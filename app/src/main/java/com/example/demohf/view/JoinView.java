package com.example.demohf.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demohf.R;
import com.example.demohf.contract.JoinContract;
import com.example.demohf.presenter.JoinPresenter;

public class JoinView extends AppCompatActivity implements JoinContract.JoinView {

    private String TAG = "JOIN_VIEW";

    private Integer[] ipId = {R.id.ip_id, R.id.ip_pwd, R.id.ip_name};
    private EditText[] etArry = new EditText[3];
    private Button joinBtn;
    private JoinContract.JoinPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_join);
        init();
    }

    @Override
    public void init() {
        for (int i = 0; i < ipId.length; i++) {
            etArry[i] = (EditText) findViewById(ipId[i]);
        }
        presenter = new JoinPresenter(this);
        joinBtn = (Button) findViewById(R.id.joinBtn);
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presenter.checkJoin(String.valueOf(etArry[0].getText()), String.valueOf(etArry[1].getText()), String.valueOf(etArry[2].getText())).getResult()) {
                    startActivity(new Intent(JoinView.this, LoginView.class));
                }
            }
        });
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg + "_ERROR", Toast.LENGTH_LONG).show();
    }

}
