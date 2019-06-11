package com.example.demohf.presenter;

import android.text.TextUtils;

import com.example.demohf.contract.JoinContract;
import com.example.demohf.local.interator.JoinInterator;
import com.example.demohf.local.vo.Result;

public class JoinPresenter implements JoinContract.JoinPresenter {

    private JoinContract.JoinView view;

    public JoinPresenter(JoinContract.JoinView view) {
        this.view = view;
        //model
    }

    @Override
    public Result checkJoin(String id, String pwd, String name) {
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(pwd) || TextUtils.isEmpty(name)){
            view.onError("EDIT_TEXT_EMPTY");
            return new Result("false");
        }else{
            try{
                String url = "";
                return new JoinInterator().execute(url).get();
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }
}
