package com.example.demohf.local.interator;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.Nullable;

import com.example.demohf.local.vo.Server;
import com.example.demohf.local.vo.Store;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DetailInterator extends AsyncTask<String, Void, Store> {

    private String TAG = "DETAIL_ASYNC_TASK";

    /**
     * @name doInBackground
     * @param strings - String[]
     * @throws ConnectException
     * @throws JSONException
     * @return Store
     */
    @Override
    protected Store doInBackground(String... strings) {
        @Nullable
        String strUrl = strings[0];
        String line;
        try {
            URL url = new URL(strUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            try {
                con.setConnectTimeout(Server.CONNECT_TIME_OUT);
                con.setReadTimeout(Server.READ_TIME_OUT);
                con.setRequestMethod(Server.REQUEST_METHOD_GET);
                con.connect();
            } catch (ConnectException e) {
                e.printStackTrace();
                return null;
            }
            InputStreamReader isr = new InputStreamReader(con.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            isr.close();
            con.disconnect();

            try {
                JSONObject jo = new JSONObject(sb.toString());
                return new Store(Integer.parseInt(jo.getString("no")),
                        jo.getString("name"),
                        Integer.parseInt(jo.getString("num")),
                        changeBit(jo.getString("img")),
                        jo.getString("regdate")
                        );
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @namw changeBit
     * @param src - String
     * @return Bitmap
     */
    private Bitmap changeBit(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            try {
                con.setRequestMethod(Server.REQUEST_METHOD_GET);
                con.setReadTimeout(Server.READ_TIME_OUT);
                con.setConnectTimeout(Server.CONNECT_TIME_OUT);
                con.connect();
            } catch (ConnectException e) {
                e.printStackTrace();
                return null;
            }
            InputStream is = con.getInputStream();
            is.close();
            con.disconnect();
            return BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
