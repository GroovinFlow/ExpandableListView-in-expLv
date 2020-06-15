package com.example.simpleexpandablelistview;

import java.util.ArrayList;

public class Object_expLvItem {
    private String title;
    private ArrayList<String> items;

    public Object_expLvItem(String title, ArrayList<String> items) {
        this.title = title;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
}