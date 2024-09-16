package com.booleanuk.api.requests.repositories;

import com.booleanuk.api.requests.model.Author;

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

    public Author getOne(int id) {
        for (Author author : this.authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public Author createAuthor(Author author) {
        this.authors.add(author);
        return author;
    }

    public Author updateAuthor(int id, Author theAuthor) {
        for (Author author : this.authors) {
            if(author.getId() == id) {
                author.setName(theAuthor.getName());
                author.setEmail(theAuthor.getEmail());
                return author;
            }
        }
        return null;
    }

    public Author deleteAuthor(int id) {
        for (Author author : this.authors) {
            if (author.getId() == id) {
                this.authors.remove(author);
                return author;
            }
        }
        return null;
    }
}
