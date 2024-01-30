package com.booleanuk.api.repositories;

import com.booleanuk.api.requests.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

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
    public Author create(Author author) {
        this.authors.add(author);
        return author;
    }
    public Author updateAuthor(int id, Author author) {
        for (Author author1 : this.authors) {
            if (author1.getId() == id) {
                author1.setName(author.getName());
                author1.setEmail(author.getEmail());
                return author1;
            }
        }
        return null;
    }
    public List<Author> deleteAuthor(int id) {
        Author authorToRemove = null;
        for (Author author1 : this.authors) {
            if (author1.getId() == id) {
                authorToRemove = author1;
                break;
            }
        }
        if (authorToRemove != null) {
            this.authors.remove(authorToRemove);
            return this.authors;
        } else {
            return null;
        }

    }
}
