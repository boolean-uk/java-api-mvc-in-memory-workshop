package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("authors")
public class AuthorsController {
    private AuthorRepository theAuthors;

    public AuthorsController() {
        this.theAuthors = new AuthorRepository();
    }

    @GetMapping
    public ArrayList<Author> getAll() {
        return this.theAuthors.getAll();
    }

    @GetMapping("/{id}")
    public Author getOne(@PathVariable(name = "id") int id){
        Author author = this.theAuthors.getOne(id);
        if (author == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "dAVES NOT FOUNT MESSAGE");
        }
        return author;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author){
        return this.theAuthors.addAuthor(author);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author update(@PathVariable(name = "id") int id, @RequestBody Author author){
        return this.theAuthors.updateAuthor(author, id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Author delete(@PathVariable(name = "id") int id){
        return this.theAuthors.deleteAuthor(id);
    }



}
