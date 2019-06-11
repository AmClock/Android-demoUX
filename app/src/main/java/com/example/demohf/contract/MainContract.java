package com.example.demohf.contract;

import com.example.demohf.local.adapter.StoreListAdapter;

public interface MainContract {

    interface MainPresenter {
        StoreListAdapter storeList();
    }

    interface MainView {
        void init();
        void onError(String msg);
    }
}
