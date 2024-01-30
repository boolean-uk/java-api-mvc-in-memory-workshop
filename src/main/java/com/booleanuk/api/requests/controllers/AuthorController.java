package com.booleanuk.api.requests.controllers;
import com.booleanuk.api.requests.model.Author;
import com.booleanuk.api.requests.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("authors")
public class AuthorController {
    private AuthorRepository theAuthors;
    public AuthorController() {
        this.theAuthors = new AuthorRepository();
    }
    @GetMapping
    public List<Author> getAll() {
        return this.theAuthors.getAll();
    }
    @GetMapping("/{id}")
    public Author getOne(@PathVariable int id) {
        Author author = this.theAuthors.getOne(id);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no one");
        }
        return author;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author) {
        if (author.getName() == null || author.getEmail() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nulls in the body");
        }
        return this.theAuthors.create(author);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        return  this.theAuthors.update(id, author);
    }
    @DeleteMapping("/{id}")
    public Author deleteAuthor(@PathVariable int id) {
        return this.theAuthors.delete(id);
    }
}
