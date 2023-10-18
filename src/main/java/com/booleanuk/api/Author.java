package com.booleanuk.api;

public class Author {

    public static int CURRENTID = 1;
    private int id;
    private String name;
    private String email;

    public Author(){}

    public Author (String name, String email) {
        id = CURRENTID++;
        this.name = name;
        this.email = email;
    }

    public Author(Author author){
        this(author.getName(), author.getEmail());
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