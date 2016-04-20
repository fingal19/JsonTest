package com.example.fx50j.redrocktest.Json;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.fx50j.redrocktest.Image;
import com.example.fx50j.redrocktest.fragment.DZ;
import com.example.fx50j.redrocktest.fragment.MZ;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FX50J on 2016/4/18.
 */
public class JsonTools_MZ {
    private List<MZ.CommentsBean> mlist = new ArrayList<MZ.CommentsBean>();

    public List<MZ.CommentsBean> getList(String json_string){
        JSONTokener tokener = new JSONTokener(json_string);

        try {
            JSONObject jsonoj = (JSONObject) tokener.nextValue();
            JSONArray jsonArray = jsonoj.getJSONArray("comments");

            for (int i =  0;i < jsonArray.length();i++){
                JSONObject comment_obj = (JSONObject) jsonArray.opt(i);

                String author = comment_obj.getString("comment_author");
                String date = comment_obj.getString("comment_date");

                //pics是个List数据
                JSONArray pics = comment_obj.getJSONArray("pics");
                String url = (String) pics.opt(0);

                /**
                 * 获取bitmap数据
                 */
                Image image = new Image();
                Bitmap bitmap = image.getbitmap(url);

                String positive = comment_obj.getString("vote_positive");
                String negative = comment_obj.getString("vote_negative");

                MZ.CommentsBean comments = new MZ.CommentsBean();
                comments.setComment_author(author);
                comments.setComment_date(date);
                comments.setVote_positive(positive);
                comments.setVote_negative(negative);

                comments.setBitmap(bitmap);

                mlist.add(comments);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mlist;
    }


}