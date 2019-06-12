package com.example.demohf.presenter;

import com.example.demohf.contract.DetailContract;
import com.example.demohf.local.interator.DetailInterator;
import com.example.demohf.local.vo.Store;

/**
 * @file DetailPresenter.java
 * @author park
 */
public class DetailPreseneter implements DetailContract.DetailPresenter {
    private DetailContract.DetailView view;

    public DetailPreseneter(DetailContract.DetailView view){
        this.view = view;
        //model
    }

    /**
     * @name showDetail
     * @param no - int
     * @return Store
     */
    @Override
    public Store showDetail(int no) {
        try {
            String url = "" + no;
            return new DetailInterator().execute(url).get();
        }catch (Exception e){
            e.printStackTrace();
            view.onError("NETWORK");
            return null;
        }
    }//showDetail end

}
