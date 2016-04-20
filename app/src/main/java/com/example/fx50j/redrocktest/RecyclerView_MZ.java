package com.example.fx50j.redrocktest;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fx50j.redrocktest.Json.JsonTools_MZ;
import com.example.fx50j.redrocktest.Json.JsonUtils;
import com.example.fx50j.redrocktest.fragment.MZ;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by FX50J on 2016/4/18.
 */
public class RecyclerView_MZ extends RecyclerView.Adapter<RecyclerView_MZ.MyHolder>{

    private List<MZ.CommentsBean> mlist = new ArrayList<MZ.CommentsBean>();

    public RecyclerView_MZ(List<MZ.CommentsBean> list){
        this.mlist = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mz,parent,false);
        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        holder.mauthor.setText(mlist.get(position).getComment_author());
        holder.mdate.setText(mlist.get(position).getComment_date());
        //怎么设置图片
        /**
         * 这里要设置一个方法把  pic里的字符串转成bitmap
         */
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Image image = new Image();
//                holder.mimage.setImageBitmap(image.getbitmap(mlist.get(position).getBitmap()));
//            }
//        }).start();

        holder.mimage.setImageBitmap(mlist.get(position).getBitmap());

        holder.mpositive.setText(mlist.get(position).getVote_positive());
        holder.mnegative.setText(mlist.get(position).getVote_negative());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView mauthor;
        private TextView mdate;
        private ImageView mimage;
        private TextView mpositive;
        private TextView mnegative;
        public MyHolder(View itemView) {
            super(itemView);

            mauthor = (TextView) itemView.findViewById(R.id.author);
            mdate = (TextView) itemView.findViewById(R.id.date);
            mimage = (ImageView) itemView.findViewById(R.id.image);
            mpositive = (TextView) itemView.findViewById(R.id.positive);
            mnegative = (TextView) itemView.findViewById(R.id.negative);
        }
    }
}
