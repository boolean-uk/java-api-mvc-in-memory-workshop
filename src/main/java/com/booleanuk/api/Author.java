package com.booleanuk.api;

public class  Author {
    private static int  nextId = 1;

    private final int id;
    private String name;
    private String email;

    public Author(String name, String email) {
        this.id = nextId;
        nextId++;

        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
