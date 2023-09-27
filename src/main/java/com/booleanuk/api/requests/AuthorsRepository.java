package com.booleanuk.api.requests;

import java.util.ArrayList;
import java.util.Optional;


//Model
public class AuthorsRepository {
    private ArrayList<Author> authors;

    public AuthorsRepository() {
        this.authors = new ArrayList<>();
        this.authors.add(new Author("Author1", "email1"));
        this.authors.add(new Author("Author2", "email2"));
        this.authors.add(new Author("Author3", "email3"));

    }

    public ArrayList<Author> getAll() {
        return this.authors;
    }


    public Author getOne(int id) {
        Optional<Author> foundAuthor = this.authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst();
        return foundAuthor.orElse(null);
    }

    // methods update (id, name, email) -> returns Author, create (name, email) -> add -> return author, delete etc.
    // logic in these methods
    // then just call them in the controller class and handle errors there

    public Author create(String name, String email) {
        Author author = new Author(name, email);
        this.authors.add(author);
        return author;
    }

    public Author update(int id, String name, String email) {
        Optional<Author> foundAuthor = authors.stream()
                .filter(a -> a.getId() == id)
                .findFirst();

        if (foundAuthor.isPresent()) {
            Author existingAuthor = foundAuthor.get();
            existingAuthor.setEmail(email);
            existingAuthor.setName(name);
            return existingAuthor;
        } else {
            return null;
        }
    }

    public Author delete(int id) {
        Optional<Author> foundAuthor = authors.stream()
                .filter(a -> a.getId() == id)
                .findFirst();

        if (foundAuthor.isPresent()) {
            Author deletedAuthor = foundAuthor.get();
            this.authors.remove(deletedAuthor);
            return deletedAuthor;
        } else {
            return null;
        }
    }
}
