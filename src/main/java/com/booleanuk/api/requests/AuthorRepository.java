package com.booleanuk.api.requests;

import java.util.ArrayList;
import java.util.Iterator;

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

    public Author create (Author author) {
        this.authors.add(author);
        return author;
    }

    public Author update (int id, Author updatedAuthor) {
        for (Author author :  this.authors) {
            if (author.getId() == id) {
                author.setName(updatedAuthor.getName());
                author.setEmail(updatedAuthor.getEmail());
                return author;
            }
        }
        return null;
    }

    public Author delete(int id) {
        Iterator<Author> iterator = this.authors.iterator();
        while (iterator.hasNext()) {
            Author author = iterator.next();
            if (author.getId() == id) {
                iterator.remove();
                return author;
            }
        }
        return null;
    }
}