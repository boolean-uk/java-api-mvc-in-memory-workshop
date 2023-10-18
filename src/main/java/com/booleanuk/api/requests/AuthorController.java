package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        Author author = this.repository.getOne(id);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }
        return author;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {
        return this.repository.create(author);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author update(@PathVariable (name = "id") int id, @RequestBody Author author) {
        Author updatedAuthor = this.repository.update(id, author);
        if(updatedAuthor == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        return updatedAuthor;
    }

    @DeleteMapping("/{id}")
    public Author delete(@PathVariable (name = "id") int id) {
        Author deletedAuthor = this.repository.delete(id);
        if(deletedAuthor == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        return deletedAuthor;
    }






}
