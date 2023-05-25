package com.booleanuk.api.requests;

public class Author {
    private static int nextID =1;
    private int id;
    private String name,email;

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
        this.id = nextID;
        nextID++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
