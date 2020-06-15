package com.example.simpleexpandablelistview;

public class Object_itemOpened {
    private String lvExp;
    private String timeExpanded;

    public Object_itemOpened(String lvExp, String timeExpanded) {
        this.lvExp = lvExp;
        this.timeExpanded = timeExpanded;
    }

    public String getLvExp() {
        return lvExp;
    }

    public void setLvExp(String lvExp) {
        this.lvExp = lvExp;
    }

    public String getTimeExpanded() {
        return timeExpanded;
    }

    public void setTimeExpanded(String timeExpanded) {
        this.timeExpanded = timeExpanded;
    }
}