package com.booleanuk.api.requests;

import java.util.ArrayList;

public class PublisherRepository {
    private ArrayList<Publisher> publishers = new ArrayList<>();
    public PublisherRepository(){
        this.publishers = new ArrayList<>();

        this.publishers.add(new Publisher("Johannes", "johannes@email.com"));
        this.publishers.add(new Publisher("Alexandria", "alexandria@email.com"));
    }
    public ArrayList<Publisher> getAll(){
        return this.publishers= publishers;
    }


    public Publisher getOne(int id){
        for (Publisher publishers : this.publishers){
            if(publishers.getId() == id){
                return publishers;
            }
        }
        return null;
    }
    public Publisher addPublisher(Publisher newPublisher){
      this.publishers.add(newPublisher);
      return newPublisher;
    }

    public Publisher updatePublisher(Publisher newPublisher, int id){
        for (Publisher publishers: this.publishers){
            if(publishers.getId()== id){
                this.publishers.set(id, newPublisher);
                return newPublisher;
            }
        }
        return null;
    }
    public Publisher deletePublisher(int id){
        for ( Publisher publisher: this.publishers){
            if(publisher.getId() == id){
                this.publishers.remove(id);
                return publisher;
            }
        }
        return null;
    }
}
