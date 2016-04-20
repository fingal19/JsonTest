package com.example.fx50j.redrocktest.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fx50j.redrocktest.Image;
import com.example.fx50j.redrocktest.Json.JsonTools;
import com.example.fx50j.redrocktest.Json.JsonTools_MZ;
import com.example.fx50j.redrocktest.Json.JsonUtils;
import com.example.fx50j.redrocktest.R;
import com.example.fx50j.redrocktest.RecyclerView_MZ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FX50J on 2016/4/17.
 */
public class Fragment_MZ extends Fragment {

    private ImageView mimage;
    private TextView mtv;

    private RecyclerView_MZ mz_adapter;
    private RecyclerView mrecyclerview;
    private List<MZ.CommentsBean> mlist = new ArrayList<MZ.CommentsBean>();
    private String mz_url = "http://jandan.net/?oxwlxojflwblxbsapi=jandan.get_ooxx_comments&page=1";

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    mlist = (List<MZ.CommentsBean>) msg.obj;

                    mz_adapter = new RecyclerView_MZ(mlist);
                    LinearLayoutManager manager = new LinearLayoutManager(getContext());
                    mz_adapter.notifyDataSetChanged();
                    mrecyclerview.setLayoutManager(manager);
                    mrecyclerview.setAdapter(mz_adapter);

                    break;
                case 2:
                    Bitmap mbitmap = (Bitmap) msg.obj;
                    mimage.setImageBitmap(mbitmap);
                    break;
                default:
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mz,container,false);
        mrecyclerview = (RecyclerView) view.findViewById(R.id.recyclerView);

        init_view();


        mtv = (TextView) view.findViewById(R.id.tv);
        mimage = (ImageView) view.findViewById(R.id.image_text);
        init_Thread();


        return view;
    }

    private void init_Thread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mtv.setText("Hello--->>2");

                Image image = new Image();
                Bitmap bitmap = image.getbitmap("http://ww2.sinaimg.cn/mw600/6469180ajw1f30tkw17evj20c80eugmw.jpg");

                Message message = new Message();
                message.what = 2;
                message.obj = bitmap;
                handler.sendMessage(message);

            }
        }).start();
    }

    private void init_view() {



        new Thread(new Runnable() {
            @Override
            public void run() {
                JsonUtils ju = new JsonUtils();
                String json_string = ju.getjsonString(mz_url);
                JsonTools_MZ jt = new JsonTools_MZ();

//                mlist = jt.getList(json_string);
                List<MZ.CommentsBean> list = jt.getList(json_string);

                Message message = new Message();
                message.what = 1;
                message.obj = list;
                handler.sendMessage(message);
            }
        }).start();
    }
}
