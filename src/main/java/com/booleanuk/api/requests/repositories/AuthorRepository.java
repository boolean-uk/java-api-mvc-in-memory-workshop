package com.booleanuk.api.requests.repositories;

import com.booleanuk.api.requests.model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    private ArrayList<Author> authors;
    public AuthorRepository() {
        this.authors = new ArrayList<>();
        this.authors.add(new Author("Roald Dahl", "roal@gmail.com"));
        this.authors.add(new Author("Ian Banks", "ian@contact.org"));
    }
    public List<Author> getAll() {
        return  this.authors;
    }
    public Author getOne(int id) {
        return this.authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public Author create(Author author) {
        boolean created = this.authors.add(author);
        if(created) {
            return author;
        }
        return null;
    }
    public Author update(int id, Author updatedAuthor) {
        Author authorToUpdate = this.authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst()
                .orElse(null);
        if (authorToUpdate != null) {
            authorToUpdate.setName(updatedAuthor.getName());
            authorToUpdate.setEmail(authorToUpdate.getEmail());
        }
        authorToUpdate = this.getOne(id);
        return authorToUpdate;
    }
    public Author delete(int id) {
        Author authorToDelete = this.getOne(id);
        if (authorToDelete == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nobody found");
        }
        return  authorToDelete;
    }
}
