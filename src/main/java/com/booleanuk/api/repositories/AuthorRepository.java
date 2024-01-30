package com.booleanuk.api.repositories;

import java.util.ArrayList;
import com.booleanuk.api.models.Author;

public class AuthorRepository {
    private ArrayList<Author> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<>();

        this.authors.add(new Author("JRR Tolkien", "jrr@tolkien.com"));
        this.authors.add(new Author("Charles Dickens", "charles@bleakhouse.com"));
    }

    public ArrayList<Author> getAll() {
        return this.authors;
    }

    public Author getOne(int id) {
        for (Author author : this.authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public Author create(Author author){
        this.authors.add(author);
        return author;
    }

    public Author edit(int id, Author author){
        for (Author curAuthor : this.authors){
            if (curAuthor.getId() == id){
                int index = this.authors.indexOf(curAuthor);
                this.authors.get(index).setName(author.getName());
                this.authors.get(index).setEmail(author.getEmail());
                return author;
            }
        }
        return null;
    }

    public Author delete(int id ){
        for (Author author : this.authors){
            if (author.getId() == id){
                this.authors.remove(author);
                return author;
            }
        }
        return null;
    }
}