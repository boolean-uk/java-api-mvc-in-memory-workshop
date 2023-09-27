package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        Author author = this.theAuthors.getOne(id);
        if (author == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find that author!");
        }
        return author;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author putAuthor(@PathVariable int id, @RequestBody Author author) {
        Author theAuthor = this.theAuthors.editAuthor(id, author);
        if (theAuthor == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find that author!");
        }
        return theAuthor;
    }

    @DeleteMapping("/{id}")
    public Author deleteAuthor(@PathVariable int id) {
        Author author = this.theAuthors.deleteAuthor(id);
        if (author == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find that author!");
        }
        return author;
    }
}
