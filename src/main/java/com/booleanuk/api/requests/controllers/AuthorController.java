package com.booleanuk.api.requests.controllers;

import com.booleanuk.api.requests.models.Author;
import com.booleanuk.api.requests.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return theAuthors.getOne(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author deleteOne(@PathVariable int id) {
        return theAuthors.deleteOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createOne(@RequestBody Author author) {
        return theAuthors.createOne(author);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author updateOne(@PathVariable int id, @RequestBody Author author) {
        return theAuthors.updateOne(id, author);
    }

}
