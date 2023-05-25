package com.booleanuk.api;

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
        return theAuthors.getAll();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable (name = "id") int id) {
        Author author = theAuthors.getOne(id);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Author was not found");
        }
        return author;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {
        return theAuthors.createAuthor(author);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author update(@PathVariable(name = "id") int id ,@RequestBody Author author) {
        Author updatedAuthor = theAuthors.editAuthor(id, author);
        if (updatedAuthor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Author was not found");
        }
        return updatedAuthor;
    }

    @DeleteMapping("/{id}")
    public Author delete(@PathVariable (name = "id") int id) {
        Author author = theAuthors.deleteAuthor(id);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Author was not found");
        }
        return author;
    }
}
