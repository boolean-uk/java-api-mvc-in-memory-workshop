package com.booleanuk.api.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Publisher {

    private static int nextID = 1;
    private int id;
    private String name;
    private String city;

    public Publisher(String name, String city) {
        this.id = nextID;
        nextID++;
        this.name = name;
        this.city = city;
    }

}

