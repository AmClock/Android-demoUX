package com.example.demohf.contract;

import com.example.demohf.local.vo.Result;

public interface JoinContract {
    interface JoinPresenter{
        Result checkJoin(String id , String pwd , String name);
    }
    interface JoinView{
        void init();
        void onError(String msg);
    }
}
