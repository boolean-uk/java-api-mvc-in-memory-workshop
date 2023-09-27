package com.booleanuk.api.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Author {
    private static int nextID = 1;

    private int id;
    private String name;
    private String email;

    public Author(String name, String email) {
        this.id = nextID;
        nextID++;
        this.name = name;
        this.email = email;
    }

}