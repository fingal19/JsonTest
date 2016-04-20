package com.example.fx50j.redrocktest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fx50j.redrocktest.fragment.DZ;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by FX50J on 2016/4/18.
 */
public class RecyclerView_DZ extends RecyclerView.Adapter<RecyclerView_DZ.MyHolder> {
    List<DZ.CommentsBean>  mlist = new ArrayList<DZ.CommentsBean>();

    public RecyclerView_DZ(List<DZ.CommentsBean> list){
        this.mlist = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dz,parent,false);
        RecyclerView_DZ.MyHolder myHolder = new RecyclerView_DZ.MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.mauthor.setText(mlist.get(position).getComment_author());
        holder.mdate.setText(mlist.get(position).getComment_date());
        holder.mcontent.setText(mlist.get(position).getComment_content());
        holder.mpositive.setText(mlist.get(position).getVote_positive());
        holder.mnegative.setText(mlist.get(position).getVote_negative());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder{
        private TextView mauthor;
        private TextView mdate;
        private TextView mcontent;
        private TextView mpositive;
        private TextView mnegative;
        public MyHolder(View itemView) {
            super(itemView);

            mauthor = (TextView) itemView.findViewById(R.id.author);
            mdate = (TextView) itemView.findViewById(R.id.date);
            mcontent = (TextView) itemView.findViewById(R.id.content);
            mpositive = (TextView) itemView.findViewById(R.id.positive);
            mnegative = (TextView) itemView.findViewById(R.id.negative);
        }
    }
}
