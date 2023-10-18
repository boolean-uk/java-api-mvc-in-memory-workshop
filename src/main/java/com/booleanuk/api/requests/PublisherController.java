package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
    private PublisherRepository repository;

    public PublisherController() {
        this.repository = new PublisherRepository();
    }

    @GetMapping
    public List<Publisher> getAll() {
        return this.repository.getAll();
    }

    @GetMapping("/{id}")
    public Publisher getOne(@PathVariable (name = "id") int id) {
        Publisher publisher = this.repository.getOne(id);
        if(publisher == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        return publisher;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        return this.repository.create(publisher);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable (name = "id") int id, @RequestBody Publisher publisher) {
        Publisher publisherUpdated = this.repository.update(id, publisher);
        if(publisherUpdated == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        return publisherUpdated;
    }

    @DeleteMapping("/{id}")
    public Publisher delete(@PathVariable (name = "id") int id) {
        Publisher publisher = this.repository.delete(id);
        if(publisher == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        return publisher;
    }
}
