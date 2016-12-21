package com.bothwing.studyproject;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bothwing.studyproject.study1.RecyclerViewStudyActivity;

import java.util.ArrayList;

public class MainRecyclerViewAdpater extends RecyclerView.Adapter {
    private ArrayList<MainAdapterData> mData;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewTitle, mTextViewContents;
        public MainAdapterData.Menu mMenu;

        public ViewHolder(View v) {
            super(v);

            mTextViewTitle = (TextView) v.findViewById(R.id.title_text);
            mTextViewContents = (TextView) v.findViewById(R.id.content_text);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;

                    switch (mMenu) {
                        case MENU_RECYCLER:
                            intent = new Intent(v.getContext(), RecyclerViewStudyActivity.class);
                            break;
                        default:
                            intent = null;
                            break;
                    }

                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    public MainRecyclerViewAdpater(ArrayList<MainAdapterData> data) {
        mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_view_card, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).mMenu = mData.get(position).mMenu;
        ((ViewHolder) holder).mTextViewTitle.setText(mData.get(position).mTitle);
        ((ViewHolder) holder).mTextViewContents.setText(mData.get(position).mContents);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
