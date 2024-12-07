package com.booleanuk.api.requests;

public class Author {
    private int id;
    private static int nextId = 1;

    String name;
    String email;

    public Author(String name, String email) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
