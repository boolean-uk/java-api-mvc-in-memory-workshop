package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        Author author = authorRepository.getOne(id);
        if(author == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Author with ID: %d could not be found", id));

        return author;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {
        return authorRepository.create(author);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author update(@PathVariable (name = "id") int id, @RequestBody Author author) {
        Author updatedAuthor = authorRepository.update(id, author);
        if(updatedAuthor == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Author with ID: %d could not be found", id));

        return updatedAuthor;
    }

    @DeleteMapping("/{id}")
    public Author delete(@PathVariable (name = "id") int id) {
        Author deletedAuthor = authorRepository.delete(id);
        if(deletedAuthor == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Author with ID: %d could not be found", id));

        return deletedAuthor;

    }
}