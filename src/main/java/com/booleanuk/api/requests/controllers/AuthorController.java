package com.booleanuk.api.requests.controllers;

import com.booleanuk.api.requests.models.Author;
import com.booleanuk.api.requests.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("{id}")
    public Author getOne(@PathVariable int id) {
        Author author = this.theAuthors.getOne(id);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "That author ID does not exist!");
        }
        return author;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author) {
        Author newAuthor = this.theAuthors.addAuthor(author);
        if (newAuthor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author could not be created!");
        }
        return newAuthor;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        Author updatedAuthor = this.theAuthors.changeAuthor(id, author);
        if (updatedAuthor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author could not be updated!");
        }
        return updatedAuthor;
    }

    @DeleteMapping("{id}")
    public Author deleteAuthor(@PathVariable int id) {
        Author deletedAuthor = this.theAuthors.removeAuthor(id);
        if (deletedAuthor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author could not be deleted!");
        }
        return deletedAuthor;
    }

}
