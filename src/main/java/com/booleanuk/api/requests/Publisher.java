package com.booleanuk.api.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Publisher {
    private static int nextId = 1;
    private int id;
    private String name;
    private String city;

    public Publisher(String name, String city) {
        this.id = nextId++;
        this.name = name;
        this.city = city;
    }
}
