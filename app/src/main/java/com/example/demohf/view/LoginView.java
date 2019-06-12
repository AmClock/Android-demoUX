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
import com.example.demohf.contract.LoginContract;
import com.example.demohf.presenter.LoginPresenter;

/**
 * @file LoginView.java
 * @author park
 */
public class LoginView extends AppCompatActivity implements LoginContract.LoginView {

    private String TAG = "LOGIN_VIEW";
    private Integer[] etId = {R.id.et_id , R.id.et_pwd};
    private EditText[] etArry = new EditText[1];
    private Button loginBtn;
    private LoginContract.LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);
        init();
    }

    /**
     * @name init
     */
    @Override
    public void init() {
        presenter = new LoginPresenter(this);
        for(int i = 0 ; i < etId.length ; i++){
            etArry[i] = (EditText)findViewById(etId[i]);
        }
        loginBtn  = (Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(presenter.loginCheck(String.valueOf(etArry[0].getText()) , String.valueOf(etArry[1].getText())).getResult()){
                   /**
                    *  DO Tread  !! forget it
                    */
                   startActivity( new Intent(LoginView.this,MainView.class));
                }else{
                   onError("NETWORK");
               }
            }
        });
    }

    /**
     * @name onError
     * @param msg - String
     */
    @Override
    public void onError(String msg) {
        Toast.makeText(this , msg + "_ERROR" ,Toast.LENGTH_LONG).show();
    }

}
