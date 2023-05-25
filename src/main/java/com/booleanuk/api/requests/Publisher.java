package com.booleanuk.api.requests;

public class Publisher {
    private static int nextId = 1;
    private int id;
    private String name;
    private String city;

    public Publisher(String name, String city) {
        this.name = name;
        this.city = city;
        this.id = nextId;
        nextId++;
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
