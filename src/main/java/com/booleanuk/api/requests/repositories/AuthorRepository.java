package com.booleanuk.api.requests.repositories;

import com.booleanuk.api.requests.models.Author;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    private List<Author> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<>();

        this.authors.add(new Author("Roald Dahl", "roald@giantpeach.com"));
        this.authors.add(new Author("George Lucas", "geod@smallstone.com"));
    }

    public List<Author> getAll() {
        return this.authors;
    }

    public Author getOne(int id) {
        for (Author author : this.authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author was not found");
    }

    public Author deleteOne(int id) {
        for (Author author : this.authors) {
            if (author.getId() == id) {
                this.authors.remove(author);
                return author;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author was not found");
    }

    public Author createOne(Author author) {
        this.authors.add(author);
        return author;
    }

    public Author updateOne(int id, Author author) {
        for(Author a : this.authors) {
            if (a.getId() == id) {
                a.setName(author.getName());
                a.setEmail(author.getEmail());
                return a;
            }
        }
        return null;
    }
}
