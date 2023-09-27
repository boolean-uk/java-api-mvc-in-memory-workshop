package com.booleanuk.api.requests;

import java.util.ArrayList;
import java.util.Iterator;

public class PublisherRepo {

    private ArrayList<Publisher> publishers;

    public PublisherRepo() {
        this.publishers = new ArrayList<>();

        this.publishers.add(new Publisher("JRR Tolkien", "123 Street"));
        this.publishers.add(new Publisher("Charles Dickens", "55 Street"));
    }


    public ArrayList<Publisher> getAll() {
        return this.publishers;
    }

    public Publisher getOne(int id) {
        for (Publisher publisher : this.publishers) {
            if (publisher.getId() == id) {
                return publisher;
            }
        }
        return null;
    }

    public Publisher create (Publisher publisher) {
        this.publishers.add(publisher);
        return publisher;
    }

    public Publisher update (int id, Publisher updatedPublisher) {
        for (Publisher publisher : this.publishers) {
            if (publisher.getId() == id) {
                publisher.setName(updatedPublisher.getName());
                publisher.setCity(updatedPublisher.getCity());
                return publisher;
            }
        }
        return null;
    }

    public Publisher delete(int id) {
        Iterator<Publisher> iterator = this.publishers.iterator();
        while (iterator.hasNext()) {
            Publisher publisher = iterator.next();
            if (publisher.getId() == id) {
                iterator.remove();
                return publisher;
            }
        }
        return null;
    }

}
