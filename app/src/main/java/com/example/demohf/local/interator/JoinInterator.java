package com.example.demohf.local.interator;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.demohf.local.vo.Result;
import com.example.demohf.local.vo.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @file JoinInterator.java
 * @author park
 */
public class JoinInterator extends AsyncTask<String, Void, Result> {

    private String TAG = "JOIN_ASYNC_TASK";

    /**
     * @name doInBackground
     * @param strings - String[]
     * @throws ConnectException
     * @throws JSONException
     * @return Result - boolean
     */
    @Override
    protected Result doInBackground(String... strings) {

        @Nullable
        String strUrl = strings[0];
        String line;

        try {
            URL url = new URL(strUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            try {
                con.setRequestMethod(Server.REQUEST_METHOD_POST);
                con.setReadTimeout(Server.READ_TIME_OUT);
                con.setConnectTimeout(Server.CONNECT_TIME_OUT);
                con.connect();
            } catch (ConnectException e) {
                e.printStackTrace();
                Log.e(TAG, "ConnectException");
                return new Result("false");
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
                return new Result(jo.getString("result"));
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e(TAG, "JSONException");
                return new Result("false");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Exception");
            return new Result("false");
        }
    }

}
