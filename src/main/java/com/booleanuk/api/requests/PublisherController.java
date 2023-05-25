package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
@RestController
@RequestMapping("publishers")
public class PublisherController {
    private PublisherRepository publishers;

    public PublisherController() {
        this.publishers = new PublisherRepository();
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Publisher> getAll(){
        return this.publishers.getAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getPublisher(@PathVariable(name = "id") int id){
        if(this.publishers.getPublisher(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Publisher with given id not found");
        }
        return this.publishers.getPublisher(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher){
        return this.publishers.addPublisher(publisher);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher updatePublisher(@RequestBody Publisher publisher,@PathVariable (name = "id") int id){
        if(this.publishers.getPublisher(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Publisher with given id not found");
        }
        return this.publishers.updatePublisher(id,publisher);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher deletePublisher(@PathVariable (name = "id") int id){
        if(this.publishers.getPublisher(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Publisher with given id not found");
        }
        return this.publishers.deletePublisher(id);
    }
}
