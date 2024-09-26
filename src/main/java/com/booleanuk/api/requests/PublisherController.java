package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
@RestController
@RequestMapping("publishers")
public class PublisherController {
    private PublisherRepository publisherRepo;

    public PublisherController() {
        publisherRepo = new PublisherRepository();
    }

    @GetMapping
    public ArrayList<Publisher> getAll(){
        return this.publisherRepo.getAll();
    }

    @GetMapping("/{id}")
    public Publisher getOne(@PathVariable(name = "id") int id) {
        Publisher publisher = this.publisherRepo.getOne(id);
        if (publisher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return publisher;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        return this.publisherRepo.create(publisher.getName(), publisher.getCity());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable (name = "id") int id, @RequestBody Publisher publisher){
        Publisher p = this.publisherRepo.getOne(id);
        if (p == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return this.publisherRepo.update(id, publisher);
    }

    @DeleteMapping("/{id}")
    public Publisher delete(@PathVariable (name = "id") int id) {
        Publisher p = this.publisherRepo.getOne(id);
        if (p == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return this.publisherRepo.delete(id);
    }
}
