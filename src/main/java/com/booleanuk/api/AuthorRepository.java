package com.booleanuk.api;

import java.util.ArrayList;

public class AuthorRepository {
    private ArrayList<Author> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<>();

        this.authors.add(new Author("Charles Dickens", "charlie@leakhouse.com"));
        this.authors.add(new Author("Cervantes", "tilting@windmills.com"));
    }

    public ArrayList<Author> getAll() {
        return authors;
    }

    public Author getOne(int id) {
        for (Author author : authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public Author createAuthor(Author author) {
        this.authors.add(author);
        return this.authors.get(authors.size() -1);
    }

    public Author editAuthor(int id, Author author) {
        for (Author indexAuthor : authors) {
            if (indexAuthor.getId() == id) {
                indexAuthor.setName(author.getName());
                indexAuthor.setEmail(author.getEmail());

                return indexAuthor;
            }
        }
        return null;
    }

    public Author deleteAuthor(int id) {
        for (Author author : authors) {
            if (author.getId() == id) {
                authors.remove(author);
                return author;
            }
        }
        return null;
    }
}
