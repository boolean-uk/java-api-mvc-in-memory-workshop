package com.booleanuk.api;

import java.util.ArrayList;

public class PublisherRepository {

    private ArrayList<Publisher> publishers;

    public PublisherRepository() {
        this.publishers = new ArrayList<>();

        this.publishers.add(new Publisher("Charles Dickens", "London"));
        this.publishers.add(new Publisher("Cervantes", "Tokyo"));
    }

    public ArrayList<Publisher> getAll() {
        return publishers;
    }

    public Publisher getOne(int id) {
        for (Publisher publisher : publishers) {
            if (publisher.getId() == id) {
                return publisher;
            }
        }
        return null;
    }

    public Publisher createPublisher(Publisher publisher) {
        this.publishers.add(publisher);
        return this.publishers.get(publishers.size() -1);
    }

    public Publisher editPublisher(int id, Publisher publisher) {
        for (Publisher indexPublisher : publishers) {
            if (indexPublisher.getId() == id) {
                indexPublisher.setName(publisher.getName());
                indexPublisher.setCity(publisher.getCity());

                return indexPublisher;
            }
        }
        return null;
    }

    public Publisher deletePublisher(int id) {
        for (Publisher publisher : publishers) {
            if (publisher.getId() == id) {
                publishers.remove(publisher);
                return publisher;
            }
        }
        return null;
    }

}
