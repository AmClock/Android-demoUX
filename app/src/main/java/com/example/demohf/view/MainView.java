package com.example.demohf.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.demohf.R;
import com.example.demohf.contract.MainContract;
import com.example.demohf.presenter.MainPresenter;

public class MainView extends AppCompatActivity implements MainContract.MainView {

    private String TAG = "MAIN_VIEW";
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private MainContract.MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_main);
    }

    @Override
    public void init() {
        presenter = new MainPresenter(this);
        recyclerView = (RecyclerView)findViewById(R.id.storeList);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(presenter.storeList());
    }


    @Override
    public void onError(String msg) {
        Toast.makeText(this , msg+"_ERROR",Toast.LENGTH_LONG).show();
    }

}
