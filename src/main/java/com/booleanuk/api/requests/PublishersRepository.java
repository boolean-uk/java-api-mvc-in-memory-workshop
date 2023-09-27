package com.booleanuk.api.requests;

import java.util.ArrayList;
import java.util.Optional;

public class PublishersRepository {
    private ArrayList<Publisher> publishers;

    public PublishersRepository() {
        this.publishers = new ArrayList<>();
        this.publishers.add(new Publisher("Penguin", "New York"));
        this.publishers.add(new Publisher("Bloomsbury", "London"));
    }

    public ArrayList<Publisher> getAllPublishers() {
        return this.publishers;
    }

    public Publisher getOne(int id) {
        return this.publishers.stream()
                .filter(publisher -> publisher.getId() == id)
                .findFirst().orElse(null);
    }

    public Publisher create(String name, String city) {
        Publisher publisher = new Publisher(name, city);
        this.publishers.add(publisher);
        return publisher;
    }

    public Publisher update(int id, String name, String city) {
        Optional<Publisher> foundPublisher = this.publishers.stream()
                .filter(publisher -> publisher.getId()==id)
                .findFirst();
        if (foundPublisher.isPresent()){
            Publisher existingPublisher = foundPublisher.get();
            existingPublisher.setName(name);
            existingPublisher.setCity(city);
            return existingPublisher;
        } else {
            return null;
        }
    }

    public Publisher delete(int id) {
        Optional<Publisher> foundPublisher = this.publishers.stream()
                .filter(publisher -> publisher.getId()==id)
                .findFirst();
        if (foundPublisher.isPresent()) {
            Publisher deletedPublisher = foundPublisher.get();
            this.publishers.remove(deletedPublisher);
            return deletedPublisher;
        } else {
            return null;
        }
    }
}
