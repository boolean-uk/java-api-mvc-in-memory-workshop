package com.booleanuk.api.requests;

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
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Author> getAll(){
        return this.theAuthors.getAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthor(@PathVariable (name = "id") int id){
        if(this.theAuthors.getAuthor(id)==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Author with given id not found");
        }
        return this.theAuthors.getAuthor(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author){
        return this.theAuthors.addAuthor(author);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author updateAuthor(@RequestBody Author author, @PathVariable (name = "id") int id ){
        if(this.theAuthors.getAuthor(id)==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Author with given id not found");
        }
        return this.theAuthors.updateAuthor(id,author);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author deleteAuthor(@PathVariable (name = "id") int id ){
        if(this.theAuthors.getAuthor(id)==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Author with given id not found");
        }
        return this.theAuthors.deleteAuthor(id);
    }
}
