package com.booleanuk.api.requests.controllers;

import com.booleanuk.api.requests.model.Author;
import com.booleanuk.api.requests.repositories.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorRepository theAuthors;

    public AuthorController() {
        this.theAuthors = new AuthorRepository();
    }

    @GetMapping
    public ArrayList<Author> getAll() {
        return this.theAuthors.getAll();
    }

    @GetMapping("/{id}")
    public Author getOne(@PathVariable(name = "id") int id) {
        return this.theAuthors.getOne(id);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return this.theAuthors.createAuthor(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        return this.theAuthors.updateAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public Author deleteAuthor(@PathVariable int id) {
        return this.theAuthors.deleteAuthor(id);
    }

}
