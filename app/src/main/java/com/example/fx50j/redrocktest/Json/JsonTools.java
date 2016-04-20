package com.example.fx50j.redrocktest.Json;

import android.util.Log;

import com.example.fx50j.redrocktest.fragment.DZ;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FX50J on 2016/4/18.
 */
public class JsonTools {
    private List<DZ.CommentsBean> mlist = new ArrayList<DZ.CommentsBean>();

    public List<DZ.CommentsBean> getList(String json_string){
        JSONTokener tokener = new JSONTokener(json_string);

        try {
            JSONObject jsonoj = (JSONObject) tokener.nextValue();
            JSONArray jsonArray = jsonoj.getJSONArray("comments");

            for (int i =  0;i < jsonArray.length();i++){
                JSONObject comment_obj = (JSONObject) jsonArray.opt(i);

                String author = comment_obj.getString("comment_author");
                String date = comment_obj.getString("comment_date");
                String content = comment_obj.getString("comment_content");
                String positive = comment_obj.getString("vote_positive");
                String negative = comment_obj.getString("vote_negative");

                DZ.CommentsBean comments = new DZ.CommentsBean();
                comments.setComment_author(author);
                comments.setComment_date(date);
                comments.setVote_positive(positive);
                comments.setVote_negative(negative);
                comments.setComment_content(content);

                mlist.add(comments);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mlist;
    }


}
