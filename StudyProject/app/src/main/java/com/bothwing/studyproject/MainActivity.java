package com.bothwing.studyproject;

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
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_main);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<MainAdapterData> dataSet = new ArrayList<>();
        MainRecyclerViewAdpater recyclerViewAdpater = new MainRecyclerViewAdpater(dataSet);
        recyclerView.setAdapter(recyclerViewAdpater);

        initData(dataSet);
    }

    private void initData(ArrayList<MainAdapterData> dataSet) {
        dataSet.add(new MainAdapterData(MainAdapterData.Menu.MENU_RECYCLER, getString(R.string.main_menu1_title), getString(R.string.main_menu1_content)));
    }
}
