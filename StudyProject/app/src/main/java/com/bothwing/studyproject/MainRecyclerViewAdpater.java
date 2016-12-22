/*********************************************************************************
 * MIT License
 * <p>
 * Copyright (c) 2016 bothwing (bothwind@gmail.com)
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *********************************************************************************/
package com.bothwing.studyproject;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bothwing.studyproject.study1.RecyclerViewStudyActivity;
import com.bothwing.studyproject.study2.TabsStudyActivity;

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
                        case MENU_TABLAYOUT:
                            intent = new Intent(v.getContext(), TabsStudyActivity.class);
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
