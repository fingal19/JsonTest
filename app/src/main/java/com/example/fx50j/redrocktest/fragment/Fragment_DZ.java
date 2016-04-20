package com.example.fx50j.redrocktest.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fx50j.redrocktest.Json.JsonTools;
import com.example.fx50j.redrocktest.Json.JsonUtils;
import com.example.fx50j.redrocktest.R;
import com.example.fx50j.redrocktest.RecyclerView_DZ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FX50J on 2016/4/17.
 */
public class Fragment_DZ extends Fragment {
    private RecyclerView mrecyclerView;
    private RecyclerView_DZ dz_adapter;
    private LinearLayoutManager mmanager;
    private List<DZ.CommentsBean> mlist = new ArrayList<DZ.CommentsBean>();
    private String url_path = "http://jandan.net/?oxwlxojflwblxbsapi=jandan.get_duan_comments&page=1\n";

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    mlist = (List<DZ.CommentsBean>) msg.obj;
                    dz_adapter = new RecyclerView_DZ(mlist);
                    mmanager = new LinearLayoutManager(getContext());
                    dz_adapter.notifyDataSetChanged();
                    mrecyclerView.setLayoutManager(mmanager);
                    mrecyclerView.setAdapter(dz_adapter);


                    break;
                default:
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dz,container,false);
        mrecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        init_recycler();


        return view;
    }

    private void init_recycler() {


        new Thread(new Runnable() {
            @Override
            public void run() {
                JsonUtils ju = new JsonUtils();
                String jsonString = ju.getjsonString(url_path);
                JsonTools jt = new JsonTools();
                List<DZ.CommentsBean> list = jt.getList(jsonString);
                Log.e("mlist","成功得到mlist");

                Message message = new Message();
                message.what = 1;
                message.obj = list;
                handler.sendMessage(message);
            }
        }).start();

    }

}
