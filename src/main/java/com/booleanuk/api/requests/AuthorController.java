package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("authors")
public class AuthorController {
    //Spring Applications,
    // do not use the same variable like in authors Class. To not get confused
    // get access to the AuthorRepository from AuthorController
    private AuthorRepository theAuthors;
    public AuthorController (){
        // make a new copy of it
        this.theAuthors = new AuthorRepository();

    }

    @GetMapping
    public ArrayList<Author> getAll() {
        // return
        return this.theAuthors.getAll();
    }

    @GetMapping("/{id}")
    public Author getOne(@PathVariable(name = "id") int id) {
        Author author = this.theAuthors.getOne(id);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return author;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {
        return this.theAuthors.create(author.getName(), author.getEmail());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author update(@PathVariable (name = "id") int id, @RequestBody Author author){
        Author a = this.theAuthors.getOne(id);
            if (a == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
            }
        return this.theAuthors.update(id, author);
    }

    @DeleteMapping("/{id}")
    public Author delete(@PathVariable (name = "id") int id) {
        Author a = this.theAuthors.getOne(id);
        if (a == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return this.theAuthors.delete(id);
    }
}
