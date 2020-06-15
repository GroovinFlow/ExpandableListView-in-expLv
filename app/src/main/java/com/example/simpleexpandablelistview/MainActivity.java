package com.example.simpleexpandablelistview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQL_database sql_database = new SQL_database(this);
        sql_database.deleteItemOpened();

        final ExpandableListView listView = (ExpandableListView) findViewById(R.id.lvExp);
        initData();
        final ExpandableListAdapter listAdapter = new ExpandableListAdapter(this, listDataHeader, listHashMap);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("Header 1");
        List<String> list1 = new ArrayList<>();
        list1.add("title1");
        list1.add("title2");
        list1.add("title3");

        listHashMap.put(listDataHeader.get(0),list1);
    }
}
