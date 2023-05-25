package com.booleanuk.api.requests;

public class Author {
    // with static it belongs to the whole class, its shared to al the next instances
    private static int nextId = 1;
    private int id;
    private String name;
    private String email;

    // do not paste the id in the Author object
    public Author(String name, String email) {
        // everytime we need an id set the next to it and increment it with 1
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
