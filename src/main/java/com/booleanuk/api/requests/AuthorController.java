package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private AuthorRepository repository;

    public AuthorController() {
        this.repository = new AuthorRepository();
    }

    @GetMapping
    public List<Author> getAll() {
        return this.repository.getAll();
    }

    @GetMapping("/{id}")
    public Author getOne(@PathVariable (name = "id") int id) {
        return this.repository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {
        return this.repository.create(author);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author update(@PathVariable (name = "id") int id, @RequestBody Author author) {
        return this.repository.update(id, author);
    }

    @DeleteMapping("/{id}")
    public Author delete(@PathVariable (name = "id") int id) {
        return this.repository.delete(id);
    }






}
