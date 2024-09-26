package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private AuthorRepository theAuthors;

    public AuthorController() {
        this.theAuthors = new AuthorRepository();
    }

    @GetMapping
    public ArrayList<Author> getAllAuthors() {
        return this.theAuthors.getAll();
    }

    @GetMapping("/{id}")
    public Author getOneAuthor(@PathVariable int id) {
        return this.theAuthors.getOne(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author updateAuthor(@PathVariable int id, @RequestBody Author newAuthor){
        if (this.theAuthors.getOne(id) != null) {
            this.theAuthors.getOne(id).setId(newAuthor.getId());
            this.theAuthors.getOne(id).setName(newAuthor.getName());
            this.theAuthors.getOne(id).setEmail(newAuthor.getEmail());
            return this.theAuthors.getOne(id);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Author deleteAuthor(@PathVariable int id) {
        if (this.theAuthors.getOne(id) != null) {
            Author author = this.theAuthors.getOne(id);
            this.theAuthors.getAll().remove(this.theAuthors.getOne(id));
            return author;
        }
        return null;
    }

}
