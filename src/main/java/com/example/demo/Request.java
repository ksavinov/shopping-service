package com.example.demo;

public class Request<Entity> {

    private Entity data;

    Entity getData() {
        return data;
    }

    public void setData(Entity data) {
        this.data = data;
    }

}
