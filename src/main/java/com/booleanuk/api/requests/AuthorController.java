package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ArrayList<Author>> getAll() {
        return new ResponseEntity<>(this.theAuthors.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getOne(@PathVariable (name = "id") int id) {
        Author author = this.theAuthors.getOne(id);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody Author createdAuthor) {
        Author author = this.theAuthors.create(createdAuthor);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable int id, @RequestBody Author updatedAuthor) {
        Author author = this.theAuthors.update(id, updatedAuthor);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> delete(@PathVariable int id) {
        Author author = this.theAuthors.delete(id);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }
}