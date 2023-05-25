package com.booleanuk.api.requests;

import java.util.ArrayList;

public class PublisherRepository {
    private ArrayList<Publisher> publishers;

    public PublisherRepository() {
        this.publishers = new ArrayList<>();
        this.publishers.add(new Publisher("Me","Athens"));
        this.publishers.add(new Publisher("You","London"));
    }

    public ArrayList<Publisher> getAll() {
        return publishers;
    }
    public  Publisher getPublisher(int id){
        for(Publisher publisher:this.publishers){
            if(publisher.getId()==id){
                return publisher;
            }
        }
        return null;
    }
    public Publisher addPublisher(Publisher publisher){
        this.publishers.add(publisher);
        return publisher;
    }
    public Publisher updatePublisher(int id, Publisher publisher){
        for(Publisher temp:this.publishers){
            if(temp.getId()==id){
                temp.setName(publisher.getName());
                temp.setCity(publisher.getCity());
                return temp;
            }
        }
        return null;
    }
    public Publisher deletePublisher(int id){
        for(Publisher temp:this.publishers){
            if(temp.getId()==id){
                return this.publishers.remove(this.publishers.indexOf(temp));
            }
        }
        return null;
    }
}
