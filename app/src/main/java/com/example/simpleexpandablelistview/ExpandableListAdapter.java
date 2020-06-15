package com.example.simpleexpandablelistview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;
    private ArrayList<String> recipients;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listHashMap.get(listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listHashMap.get(listDataHeader.get(i)).get(i1); // i = Group Item , i1 = ChildItem
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String)getGroup(i);
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_group,null);
        }
        TextView lblListHeader = (TextView)view.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String childText = (String)getChild(i,i1);
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item,null);
        }

        ExpandableListView txtListChild = (ExpandableListView) view.findViewById(R.id.lblListItem1);
        ExpandableListAdapterTextView listAdapter = new ExpandableListAdapterTextView(context, listDataHeader, listHashMap);
        txtListChild.setAdapter(listAdapter);
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();
        listDataHeader.add("Title 1");
        listDataHeader.add("Title 2");
        listDataHeader.add("Title 3");
        List<String> list1 = new ArrayList<>();
        list1.add("L1 Expandable item 1");
        List<String> list2 = new ArrayList<>();
        list2.add("L2 Expandable item 1");
        list2.add("L2 Expandable item 2");
        List<String> list3 = new ArrayList<>();
        list3.add("L3 Expandable item 1");
        list3.add("L3 Expandable item 2");
        list3.add("L3 Expandable item 3");
        listHashMap.put(listDataHeader.get(0),list1);
        listHashMap.put(listDataHeader.get(1),list2);
        listHashMap.put(listDataHeader.get(2),list3);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
