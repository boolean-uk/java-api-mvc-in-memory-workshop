package com.booleanuk.api.requests.models;

public class Author {
    private static int nextID = 1;

    private int id;
    private String name;
    private String email;

    public Author() {
        this.id = nextID;
        nextID++;
    }

    public Author(String name, String email) {
        this.name = name;
        this.email = email;

        this.id = nextID;
        nextID++;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
