package com.booleanuk.api.requests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping
public class PublisherController {
   private PublisherRepository thePublishers;

   public PublisherController(){
       this.thePublishers = new PublisherRepository();
   }
    @GetMapping
    public ArrayList<Publisher> getAll() {
        return this.thePublishers.getAll();
    }

    @GetMapping("/{id}")
    public Publisher getOne(@PathVariable(name = "id") int id){
        Publisher Pub = this.thePublishers.getOne(id);
        if (Pub == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "dAVES NOT FOUNT MESSAGE");
        }
        return Pub;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher){
        return this.thePublishers.addPublisher(publisher);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable(name = "id") int id, @RequestBody Publisher publisher){
        Publisher Pub = this.thePublishers.updatePublisher(publisher, id);
        if (Pub == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PUBLISHER NOT FOUNT MESSAGE");
        }
        return Pub;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Publisher delete(@PathVariable(name = "id") int id){
        Publisher Pub = this.thePublishers.deletePublisher(id);
        if (Pub == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PUBLISHER NOT FOUNT MESSAGE");
        }
        return Pub;
    }


}
