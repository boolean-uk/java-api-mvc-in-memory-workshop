package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@RequestMapping("publishers")
public class PublisherController {
    private PublisherRepository thePublishers;

    public PublisherController() {
        this.thePublishers = new PublisherRepository();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Collection<Publisher> getPublishers() {
        return thePublishers.getAll();
    }

    @GetMapping("/{id}")
    public Publisher getPublisher(@PathVariable (name = "id") int id) {
        Publisher publisher = thePublishers.getOne(id);
        if (publisher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Publisher was not found");
        }
        return publisher;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        return thePublishers.createPublisher(publisher);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable(name = "id") int id ,@RequestBody Publisher publisher) {
        Publisher updatedPublisher = thePublishers.editPublisher(id, publisher);
        if (updatedPublisher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Publisher was not found");
        }
        return updatedPublisher;
    }

    @DeleteMapping("/{id}")
    public Publisher delete(@PathVariable (name = "id") int id) {
        Publisher publisher = thePublishers.deletePublisher(id);
        if (publisher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Publisher was not found");
        }
        return publisher;
    }
}
