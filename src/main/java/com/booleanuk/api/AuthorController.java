package com.booleanuk.api;

import org.springframework.http.HttpStatus;
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
        return theAuthors.getAll();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable (name = "id") int id) {
        return theAuthors.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {
        return theAuthors.createAuthor(author);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author update(@PathVariable(name = "id") int id ,@RequestBody Author author) {
        return theAuthors.editAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public Author delete(@PathVariable (name = "id") int id) {
        return theAuthors.deleteAuthor(id);
    }
}
