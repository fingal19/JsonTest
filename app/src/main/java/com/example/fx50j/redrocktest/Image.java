package com.example.fx50j.redrocktest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by FX50J on 2016/4/18.
 */
public class Image {
    public Bitmap getbitmap(String image_url){
        Bitmap mbitmap = null;
        try {
            URL url = new URL(image_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();

            InputStream is = connection.getInputStream();
            mbitmap = BitmapFactory.decodeStream(is);
            is.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return mbitmap;
    }
}
