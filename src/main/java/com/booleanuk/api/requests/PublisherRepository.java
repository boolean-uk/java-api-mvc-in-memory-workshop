package com.booleanuk.api.requests;

import java.util.ArrayList;

public class PublisherRepository {
    private ArrayList<Publisher> publishers;

    public PublisherRepository() {
        this.publishers = new ArrayList<>();

        this.publishers.add(new Publisher("Morten", "Amsterdam"));
        this.publishers.add(new Publisher("Rebeka", "Copenhagen"));
        this.publishers.add(new Publisher("John", "Paris"));
    }
    public ArrayList<Publisher> getAll() {
        return this.publishers;
    }

    // method that sends back an Author
    public Publisher getOne(int id){
        // go to the database of id
        for (Publisher publisher : this.publishers) {
            // make it an author and return it
            if (publisher.getId() == id) {
                return publisher;
            }
        }
        // otherwise return null
        return null;
    }

    public Publisher create(String name, String city) {
        Publisher p = new Publisher(name, city);
        this.publishers.add(p);
        return p;
    }

    public Publisher update(int id, Publisher publisher){
        for (Publisher p : this.publishers) {
            if (id == p.getId()) {
                p.setName(publisher.getName());
                p.setCity(publisher.getCity());
                return p;
            }
        }
        return null;
    }

    public Publisher delete(int id){
        for(Publisher p : this.publishers) {
            if (id == p.getId()) {
                this.publishers.remove(p);
                return p;
            }
        }
        return null;
    }
}
