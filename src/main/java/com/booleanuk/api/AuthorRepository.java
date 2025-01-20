package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

public class AuthorRepository {
    private ArrayList<Author> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<>();

        this.authors.add(new Author("JRR Tolkien", "jrr@tolkien.com"));
        this.authors.add(new Author("Charles Dickens", "charles@bleakhouse.com"));
    }

    public ArrayList<Author> getAll() {
        return this.authors;
    }

    public Author create(Author author) {
        this.authors.add(author);
        return author;
    }

    public Author getOne(int id) {
        for (Author author : this.authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public Author putAuthor(int id, Author author) {
        for (Author a : this.authors) {
            if (a.getId() == id) {
                a.setName(author.getName());
                a.setEmail(author.getEmail());
                return a;
            }
        }
        return null;
    }

    public Author delete(int id) {
        Author toDelete;
        for (Author a : this.authors) {
            if (a.getId() == id) {
                toDelete = a;
                authors.remove(a);
                return toDelete;
            }
        }
        return null;
    }
}