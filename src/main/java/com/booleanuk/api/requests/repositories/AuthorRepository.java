package com.booleanuk.api.requests.repositories;

import com.booleanuk.api.requests.models.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    private ArrayList<Author> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<>();

        this.authors.add(new Author("Ronald Dahl", "roald@giantpeach.com"));
        this.authors.add(new Author("Iain M Banks", "iain@contact.org"));
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

    public Author addAuthor(Author author) {
        boolean created = this.authors.add(author);
        if (created) {
            return author;
        }
        return null;
    }

    public Author changeAuthor(int id, Author author) {
        for (Author authorToUpdate : this.authors) {
            if (authorToUpdate.getId() == id) {
                authorToUpdate.setName(author.getName());
                authorToUpdate.setEmail(author.getEmail());
                return authorToUpdate;
            }
        }
        return null;
    }

    public Author removeAuthor(int id) {
        for (Author authorToRemove : this.authors) {
            if (authorToRemove.getId() == id) {
                this.authors.remove(authorToRemove);
                return authorToRemove;
            }
        }
        return null;
    }
}
