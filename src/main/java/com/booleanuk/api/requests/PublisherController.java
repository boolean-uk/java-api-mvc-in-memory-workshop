package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

import static org.springframework.util.StringUtils.hasLength;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
    private PublishersRepository publishersRepository;

    public PublisherController() {
        this.publishersRepository = new PublishersRepository();
    }

    @GetMapping
    public ArrayList<Publisher> getPublishers() {
        return this.publishersRepository.getAllPublishers();
    }

    @GetMapping("/{id}")
    public Publisher getSpecificPublisher(@PathVariable int id) {
        Publisher publisher = this.publishersRepository.getOne(id);
        if (publisher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher not found.");
        }
        return publisher;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        if (!hasLength(publisher.getName()) || !hasLength(publisher.getCity())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name and city are required.");
        }
        return this.publishersRepository.create(publisher.getName(), publisher.getCity());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable(name = "id") int id, @RequestBody Publisher publisher) {
        if (!hasLength(publisher.getName()) || !hasLength(publisher.getCity())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name and city are required.");
        }
        Publisher updatedPublisher = this.publishersRepository.update(id, publisher.getName(), publisher.getCity());
        if (updatedPublisher != null) {
            return updatedPublisher;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher not found.");
        }
    }

    @DeleteMapping("/{id}")
    public Publisher delete(@PathVariable(name = "id") int id) {
       Publisher deletedAuthor = this.publishersRepository.delete(id);
        if (deletedAuthor != null) {
            return deletedAuthor;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher not found.");
        }
    }
}
