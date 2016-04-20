package com.example.fx50j.redrocktest.Json;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by FX50J on 2016/4/18.
 */
public class JsonUtils {

    public String getjsonString(String url_path){
        String jsonString  = "";
        try {
            URL url = new URL(url_path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(6000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);

            int connectioncode = connection.getResponseCode();
            if (connectioncode == 200){
                InputStream is = connection.getInputStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                byte[] data = new byte[1024];
                int len = 0;
                while ((len = is.read(data)) != -1){
                    outputStream.write(data,0,len);
                }
                jsonString = new String(outputStream.toByteArray());

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.e("jsonString",jsonString + "");
        return jsonString;
    }


}
