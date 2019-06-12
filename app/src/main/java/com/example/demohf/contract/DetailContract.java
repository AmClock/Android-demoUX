package com.example.demohf.contract;

import com.example.demohf.local.vo.Store;

/**
 * @author park
 * @file DetailContract.java
 */
public interface DetailContract {

    interface DetailPresenter {
            Store showDetail(int no);
    }
    interface DetailView {
        void init();
        void onError(String msg);
    }
}//DetailContract
