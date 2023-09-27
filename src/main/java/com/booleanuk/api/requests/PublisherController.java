package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("publishers")
public class PublisherController {

    private PublisherRepo thePublishers;

    public PublisherController() {
        this.thePublishers = new PublisherRepo();
    }

    @GetMapping
    public ResponseEntity<ArrayList<Publisher>> getAll() {
        return new ResponseEntity<>(this.thePublishers.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getOne(@PathVariable(name = "id") int id) {
        Publisher publisher = this.thePublishers.getOne(id);
        if (publisher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Publisher> create(@RequestBody Publisher createdPublisher) {
        Publisher publisher = this.thePublishers.create(createdPublisher);
        return new ResponseEntity<>(publisher, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> update(@PathVariable int id, @RequestBody Publisher updatedPublisher) {
        Publisher publisher = this.thePublishers.update(id, updatedPublisher);
        if (publisher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Publisher> delete(@PathVariable int id) {
        Publisher publisher = this.thePublishers.delete(id);
        if (publisher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }
}
