package com.example.demo;

public class Response<Entity> {

    private Entity data;

    public Entity getData() {
        return data;
    }

    void setData(Entity data) {
        this.data = data;
    }

}
