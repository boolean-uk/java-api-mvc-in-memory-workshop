package com.booleanuk.api.controllers;

import com.booleanuk.api.models.Author;
import com.booleanuk.api.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("authors")
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
        Author author = this.theAuthors.getOne(id);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return author;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author){
        return this.theAuthors.create(author);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author editAuthor(@PathVariable(name = "id") int id, @RequestBody Author author){
        return this.theAuthors.edit(id, author);
    }

    @DeleteMapping("/{id}")
    public Author deleteAuthor(@PathVariable(name="id") int id){
        return this.theAuthors.delete(id);
    }
}
