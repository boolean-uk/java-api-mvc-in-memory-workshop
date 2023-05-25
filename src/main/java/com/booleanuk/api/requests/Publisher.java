package com.booleanuk.api.requests;

public class Publisher {
    private static int nextId =1;
    private int id;
    private String name,city;

    public Publisher(String name, String city) {
        this.name = name;
        this.city = city;
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
