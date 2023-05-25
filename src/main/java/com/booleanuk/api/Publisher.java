package com.booleanuk.api;

public class Publisher {
    private static int  nextId = 1;

    private int id;
    private String name;
    private String city;

    public Publisher(String name, String city) {
        this.id = nextId;
        nextId++;

        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
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

    public void setCity(String email) {
        this.city = email;
    }
}
