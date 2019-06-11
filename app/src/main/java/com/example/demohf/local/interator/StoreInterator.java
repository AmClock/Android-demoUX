package com.example.demohf.local.interator;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import com.example.demohf.local.vo.Server;
import com.example.demohf.local.vo.Store;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class StoreInterator extends AsyncTask<String, Void, ArrayList<Store>> {

    @Override
    protected ArrayList<Store> doInBackground(String... strings) {
        @Nullable
        String strUrl = strings[0];
        String line;
        ArrayList<Store> list = new ArrayList<>();
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

                JSONArray ja = new JSONArray(sb.toString());
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject jo = ja.getJSONObject(i);
                    list.add(new Store(
                            Integer.parseInt(jo.getString("no")),
                            jo.getString("name"),
                            Integer.parseInt(jo.getString("num")),
                            changeBit(jo.getString("img")),
                            jo.getString("regdate")
                    ));
                }

                return list;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Bitmap changeBit(String src) {
        try {
            // src change
            URL url = new URL(src);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            try {
                con.setRequestMethod(Server.REQUEST_METHOD_GET);
                con.setReadTimeout(Server.READ_TIME_OUT);
                con.setConnectTimeout(Server.CONNECT_TIME_OUT);
                con.connect();
                InputStream is = con.getInputStream();
                is.close();
                con.disconnect();
                return BitmapFactory.decodeStream(is);
            } catch (ConnectException e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
