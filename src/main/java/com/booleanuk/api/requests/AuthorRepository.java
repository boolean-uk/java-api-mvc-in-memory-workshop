package com.booleanuk.api.requests;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorRepository {
    private List<Author> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<>();

        this.authors.add(new Author("Charles Dickens", "charles@gmail.com"));
        this.authors.add(new Author("Cervantes", "cervantes@hotmail.com"));
    }

    public List<Author> getAll() {
        return this.authors;
    }

    public Author getOne(int id) {
        for (Author author : this.authors) {
            if(author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public Author create(Author author) {
        this.authors.add(author);
        return author;
    }

    public Author update(int id, Author author) {
        Optional<Author> oldAuthor = this.authors.stream().filter(x -> x.getId() == id).findFirst();
        if (oldAuthor.isPresent()) {
            oldAuthor.get().setName(author.getName());
            oldAuthor.get().setEmail(author.getEmail());
            return oldAuthor.get();
        }
        return null;
    }

    public Author delete(int id) {
        Optional<Author> oldAuthor = this.authors.stream().filter(x -> x.getId() == id).findFirst();
        if (oldAuthor.isPresent()) {
            this.authors.remove(oldAuthor.get());
            return oldAuthor.get();
        }
        return null;
    }


}
