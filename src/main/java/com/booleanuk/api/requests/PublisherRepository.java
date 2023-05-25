package com.booleanuk.api.requests;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PublisherRepository {
    private List<Publisher> publishers;

    public PublisherRepository() {
        this.publishers = new ArrayList<>();

        this.publishers.add(new Publisher("Charles Dickens", "Rotterdam"));
        this.publishers.add(new Publisher("Cervantes", "Aarhus"));
    }

    public List<Publisher> getAll() {
        return this.publishers;
    }

    public Publisher getOne(int id) {
        for (Publisher publisher : this.publishers) {
            if(publisher.getId() == id) {
                return publisher;
            }
        }
        return null;
    }

    public Publisher create(Publisher publisher) {
        this.publishers.add(publisher);
        return publisher;
    }

    public Publisher update(int id, Publisher publisher) {
        for (Publisher publisherUpdated : this.publishers) {
            if(publisherUpdated.getId() == id) {
                publisherUpdated.setName(publisher.getName());
                publisherUpdated.setCity(publisher.getCity());
                return publisherUpdated;
            }
        }
        return null;
    }

    public Publisher delete(int id) {
        for (Publisher publisher : this.publishers) {
            if(publisher.getId() == id) {
                this.publishers.remove(publisher);
                return publisher;
            }
        }
        return null;
    }
}
