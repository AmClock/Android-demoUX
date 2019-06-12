package com.example.demohf.contract;

import com.example.demohf.local.adapter.StoreListAdapter;

/**
 * @file MainContract.java
 * @author park
 */
public interface MainContract {

    interface MainPresenter {
        StoreListAdapter storeList();
    }

    interface MainView {
        void init();
        void onError(String msg);
    }
}
