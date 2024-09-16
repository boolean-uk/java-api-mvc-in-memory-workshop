package com.booleanuk.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorRepository {
    private Map<Integer, Author> authors;

    public AuthorRepository() {
        this.authors = new HashMap<>();
        Author firstAuthor = new Author("Charles Dickens", "charlie@bleakhouse.com");
        this.authors.put(firstAuthor.getId(), firstAuthor);
        Author secondAuthor = new Author("Cervantes", "tilting@windmills.com");
        this.authors.put(secondAuthor.getId(), secondAuthor);
    }

    public List<Author> getAll() {
        return this.authors.values().stream().toList();
    }

    public Author getOne(int id) {
        return authors.get(id);
    }

    public Author create(Author author){
        Author instance = new Author(author);
        authors.put(instance.getId(), instance);
        return instance;
    }

    public Author update(int id, Author newAuthor){
        Author old = authors.get(id);
        if(old == null) return null;

        old.setName(newAuthor.getName());
        old.setEmail(newAuthor.getEmail());
        authors.replace(id, old);
        return authors.get(id);
    }

    public Author delete(int id){
        return  authors.remove(id);
    }
}