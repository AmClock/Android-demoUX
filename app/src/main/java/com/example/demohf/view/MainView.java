package com.example.demohf.view;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.demohf.R;
import com.example.demohf.contract.MainContract;
import com.example.demohf.presenter.MainPresenter;
/**
 * @file MainView.java
 * @author park
 */
public class MainView extends AppCompatActivity implements MainContract.MainView {

    private String TAG = "MAIN_VIEW";
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private MainContract.MainPresenter presenter;

//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        ActionBar actionBar = getSupportActionBar();
//
//        actionBar.setDisplayShowCustomEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(false);
//        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayShowHomeEnabled(false);
//
//
//        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
//        View actionbar = inflater.inflate(R.layout.action_bar, null);
//
//        actionBar.setCustomView(actionbar);
//
//        Toolbar parent = (Toolbar)actionbar.getParent();
//        parent.setContentInsetsAbsolute(0,0);
//
//        return true;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_main);
        init();
    }//onCreate end

    /**
     * @name init
     * @return void
     */
    @Override
    public void init() {
        presenter = new MainPresenter(this);
        recyclerView = (RecyclerView)findViewById(R.id.storeList);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(presenter.storeList());
    }//init end

    /**
     * @name onError
     * @param msg
     */
    @Override
    public void onError(String msg) {
        Toast.makeText(this , msg+"_ERROR",Toast.LENGTH_LONG).show();
    }//onError end

}
