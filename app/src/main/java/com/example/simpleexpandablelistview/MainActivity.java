package com.example.simpleexpandablelistview;

import android.os.Bundle;
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

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.lvExp);
        initData();

        ExpandableListAdapter listAdapter = new ExpandableListAdapter(this, listDataHeader, listHashMap);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("Title 1");
        listDataHeader.add("Title 2");
        listDataHeader.add("Title 3");

        List<String> list1 = new ArrayList<>();
        list1.add("L1 Expandable item 1");

        List<String> list2 = new ArrayList<>();
        list2.add("L2 Expandable item 1");

        List<String> list3 = new ArrayList<>();
        list3.add("L3 Expandable item 1");
        list3.add("L3 Expandable item 2");
        list3.add("L3 Expandable item 3");

        listHashMap.put(listDataHeader.get(0),list1);
        listHashMap.put(listDataHeader.get(1),list2);
        listHashMap.put(listDataHeader.get(2),list3);
    }
}
