package com.booleanuk.api.requests;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AuthorRepository {
    // where the ArrayLists live
    private ArrayList<Author> authors;
    public AuthorRepository(){
        this.authors = new ArrayList<>();
        this.authors.add(new Author("Charles Dickens", "charlie@bleakhouse.com"));
        this.authors.add(new Author("Cervantes", "tilling@sindmmill.com"));

    }
    // method that gets all the
    public ArrayList<Author> getAll() {
        return this.authors;
    }

    // method that sends back an Author
    public Author getOne(int id){
        // go to the database of id
        for (Author author : this.authors) {
            // make it an author and return it
            if (author.getId() == id) {
                return author;
            }
        }
        // otherwise return null
        return null;
    }

    public Author create(String name, String email) {
        Author a = new Author(name, email);
        this.authors.add(a);
        return a;
    }

    public Author update(int id, Author author){
        for (Author a : this.authors) {
            if (id == a.getId()) {
                a.setName(author.getName());
                a.setEmail(author.getEmail());
                return a;
            }
        }
        return null;
    }

    public Author delete(int id){
        for(Author a : this.authors) {
            if (id == a.getId()) {
                this.authors.remove(a);
                return a;
            }
        }
        return null;
    }
}
