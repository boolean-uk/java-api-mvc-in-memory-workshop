package com.booleanuk.api.requests;

import java.util.ArrayList;

// Model
public class AuthorRepository {
    private ArrayList<Author> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<>();

        this.authors.add(new Author("JRR Tolkien", "jr@gmail"));
        this.authors.add(new Author("George RR Martin","geo@hotmail.com"));
    }

    public ArrayList<Author> getAll() {
        return this.authors;
    }

    public Author getOne(int id) {
        int index = -1;
        for (Author author: authors){
            if (author.getId() == id) {
                index = this.authors.indexOf(author);
            }
        }
        if (index >= 0) {
            return this.authors.get(index);
        }
        return null;
    }
}
