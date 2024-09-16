package com.booleanuk.api.requests.model;

public class Author {
    private static int nextID = 1;
    private int id;
    private String name;
    private String email;

    public Author() {
        this.id = nextID++;
    }
    public Author(String name, String email){
        this.name = name;
        this.email = email;
        this.id = nextID++;
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

