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
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<String> listDataHeader;
    private HashMap<String,List<Object_expLvItem>> listHashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ExpandableListView listView = (ExpandableListView) findViewById(R.id.lvExp);
        initData();
        final ExpandableListAdapter listAdapter = new ExpandableListAdapter(this, listDataHeader, listHashMap);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("Header 1");
        List<Object_expLvItem> list1 = new ArrayList<>();
        // arrayLists
        ArrayList<String> arrayListI1 = new ArrayList<>();
        ArrayList<String> arrayListI2 = new ArrayList<>();
        ArrayList<String> arrayListI3 = new ArrayList<>();
        arrayListI1.add("t1_Item1");
        arrayListI1.add("t1_Item2");
        arrayListI1.add("t1_Item3");
        arrayListI2.add("t2_Item1");
        arrayListI2.add("t2_Item2");
        arrayListI2.add("t2_Item3");
        arrayListI3.add("t3_Item1");
        arrayListI3.add("t3_Item2");
        arrayListI3.add("t3_Item3");
        // adding
        list1.add(new Object_expLvItem("title1", arrayListI1));
        list1.add(new Object_expLvItem("title2", arrayListI2));
        list1.add(new Object_expLvItem("title3", arrayListI3));

        listHashMap.put(listDataHeader.get(0),list1);
    }
}
