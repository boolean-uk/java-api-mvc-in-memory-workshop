package com.booleanuk.api;

import org.springframework.web.bind.annotation.*;

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
        return this.theAuthors.getOne(id);
    }

    @PostMapping
    public Author create(@RequestBody Author author) {
        return this.theAuthors.create(author);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable(name = "id") int id, @RequestBody Author author) {
        return this.theAuthors.putAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public Author delete(@PathVariable(name = "id") int id) {
        return this.theAuthors.delete(id);
    }

}