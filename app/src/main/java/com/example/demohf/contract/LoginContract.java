package com.example.demohf.contract;

import com.example.demohf.local.vo.Result;

public interface LoginContract {
    interface LoginPresenter{
        Result loginCheck(String id , String pwd);
    }
    interface LoginView{
        void init();
        void onError(String msg);
    }
}
