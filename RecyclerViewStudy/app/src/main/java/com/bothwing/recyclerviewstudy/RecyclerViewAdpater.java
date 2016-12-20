package com.bothwing.recyclerviewstudy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdpater extends RecyclerView.Adapter {
    private ArrayList<String> mStringData;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);

            mTextView = (TextView) v.findViewById(R.id.info_text);
        }
    }

    public RecyclerViewAdpater(ArrayList<String> data) {
        mStringData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_card, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).mTextView.setText(mStringData.get(position));
    }

    @Override
    public int getItemCount() {
        return mStringData.size();
    }
}
