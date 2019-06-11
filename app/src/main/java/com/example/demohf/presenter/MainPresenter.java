package com.example.demohf.presenter;

import com.example.demohf.contract.MainContract;
import com.example.demohf.local.adapter.StoreListAdapter;
import com.example.demohf.local.interator.StoreInterator;

public class MainPresenter implements MainContract.MainPresenter {
    private MainContract.MainView view;
    public MainPresenter(MainContract.MainView view){
        this.view = view;
        //Model
    }

    @Override
    public StoreListAdapter storeList() {
        try {
            String url = "";
            return new StoreListAdapter(new StoreInterator().execute(url).get());
        }catch (Exception e){
            return null;
        }
    }
}
