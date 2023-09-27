package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository theAuthors;

    public AuthorController() {
        this.theAuthors = new AuthorRepository();
    }

    @GetMapping
    public ArrayList<Author> getAllAuthors() {
        return this.theAuthors.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author postAuthor(@RequestBody Author author) {
        return this.theAuthors.addAuthor(author);
    }

    @GetMapping("/{id}")
    public Author getOneAuthor(@PathVariable int id) {
        return this.theAuthors.getOne(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author putAuthor(@PathVariable int id, @RequestBody Author author) {
        return this.theAuthors.editAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public Author deleteAuthor(@PathVariable int id) {
        return this.theAuthors.deleteAuthor(id);
    }
}
