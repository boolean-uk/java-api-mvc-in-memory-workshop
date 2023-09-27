package com.booleanuk.api.requests;

import com.booleanuk.api.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

import static org.springframework.util.StringUtils.hasLength;

@RestController
@RequestMapping("authors")
public class AuthorController {
    private AuthorsRepository authorsRepository;

    public AuthorController() {
        this.authorsRepository = new AuthorsRepository();
    }

    @GetMapping
    public ArrayList<Author> getAllAuthors() {
        return this.authorsRepository.getAll();
    }

    @GetMapping("/{id}")
    public Author getOneAuthor(@PathVariable int id) {
        Author author = this.authorsRepository.getOne(id);

        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find the author");
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't find the author");
        }
        // this stays in controller
        // annotations in controller
        return author;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author) {
        if (!hasLength(author.getName()) || !hasLength(author.getEmail())) {
//            throw new BadRequestException("Name and email are required.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name and email are required.");

        }
        return this.authorsRepository.create(author.getName(), author.getEmail());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        if (!hasLength(author.getName()) || !hasLength(author.getEmail())) {
            throw new BadRequestException("Name and email are required.");
        }
        Author updatedAuthor = this.authorsRepository.update(id, author.getName(), author.getEmail());

        if (updatedAuthor != null) {
            return updatedAuthor;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find the author");
        }
    }

    @DeleteMapping("/{id}")
    public Author deleteAuthor(@PathVariable int id) {
        Author deletedAuthor = this.authorsRepository.delete(id);

        if (deletedAuthor != null) {
            return deletedAuthor;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find the author");
        }
    }
}
