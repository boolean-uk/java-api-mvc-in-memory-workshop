package com.booleanuk.api.controllers;

import com.booleanuk.api.repositories.AuthorRepository;
import com.booleanuk.api.requests.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ArrayList<Author> getAll() {
        return this.theAuthors.getAll();
    }
    @GetMapping("/{id}")
    public Author getOne(@PathVariable(name = "id") int id) {
        return this.theAuthors.getOne(id);
    }
    @PostMapping
    public Author create(@RequestBody Author author){
        return this.theAuthors.create(author);
    }
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author){
        return this.theAuthors.updateAuthor(id, author);
    }
    @DeleteMapping("/{id}")
    public List<Author> deleteAuthor(@PathVariable int id){
        return this.theAuthors.deleteAuthor(id);
    }

}