package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("authors")
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController() {
        authorRepository = new AuthorRepository();
    }

    @GetMapping
    public List<Author> getAll() {
        return authorRepository.getAll();
    }

    @GetMapping("/{id}")
    public Author getOne(@PathVariable (name = "id") int id) {
       return authorRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {
        return authorRepository.create(author);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author update(@PathVariable (name = "id") int id, @RequestBody Author author) {
        return authorRepository.update(id, author);
    }

    @DeleteMapping("/{id}")
    public Author delete(@PathVariable (name = "id") int id) {
        return authorRepository.delete(id);
    }
}