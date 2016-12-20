package com.bothwing.recyclerviewstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<String> dataSet = new ArrayList<>();
        RecyclerViewAdpater recyclerViewAdpater = new RecyclerViewAdpater(dataSet);
        recyclerView.setAdapter(recyclerViewAdpater);

        initData(dataSet);
    }

    private void initData(ArrayList<String> dataList) {
        dataList.add(0, "Android study");
        dataList.add(1, "Recycler View");
        dataList.add(2, "Card View");
        dataList.add(3, "Samples");
    }
}