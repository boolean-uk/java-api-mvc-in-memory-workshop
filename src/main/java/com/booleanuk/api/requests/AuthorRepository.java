package com.booleanuk.api.requests;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    private ArrayList<Author> authors = new ArrayList<>();

    public AuthorRepository() {
        this.authors =  new ArrayList<>();

        this.authors.add(new Author("Charles Dickens", "dickens@charles.com"));
        this.authors.add(new Author("Cervantes", "cervantes@iguelde.com"));
    }

    public ArrayList<Author> getAll(){
        return this.authors;
    }

    //go to the database,
    public Author getOne(int id) {
        for (Author author: this.authors){
            if(author.getId() == id){
                return author;
            }
        }
        return null;
    }

    public Author addAuthor(Author newAuthor){
        this.authors.add(newAuthor);
        return newAuthor;
    }

    public Author updateAuthor(Author newAuthor, int id){ //updateAuthor(Miguel Hernandez, 2)
        for (Author author: this.authors){
            if(author.getId() == id){
                this.authors.set(id, newAuthor);
                return newAuthor;
            }
        }
        return null;
    }

    public Author deleteAuthor(int id){
        for (Author author: this.authors){
            if(author.getId() == id){
                this.authors.remove(id);
                return author;
            }
        }
        return null;
    }



}
