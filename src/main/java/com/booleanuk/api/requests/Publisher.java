package com.booleanuk.api.requests;

public class Publisher {
    private int id;
    private static int nextId = 1;

    String name;
    String city;

    public Publisher(String name, String city) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
