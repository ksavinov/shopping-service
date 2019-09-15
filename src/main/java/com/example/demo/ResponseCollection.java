package com.example.demo;

import java.util.ArrayList;

public class ResponseCollection<Entity> {

    private ArrayList<Entity> data;

    ResponseCollection() {
        this.data = new ArrayList<>();
    }

    public ArrayList<Entity> getData() {
        return data;
    }

    public void setData(ArrayList<Entity> data) {
        this.data = data;
    }

    void addItem(Entity entity) {
        this.data.add(entity);
    }

}
