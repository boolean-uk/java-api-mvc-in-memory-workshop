package com.booleanuk.api.requests;

import java.util.ArrayList;

public class AuthorRepository {
    private ArrayList<Author> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<>();
        this.authors.add(new Author("Dennis Voutos", "me@mail.com"));
        this.authors.add(new Author("Makis Voutos", "brother@mail.com"));
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }
    public ArrayList<Author> getAll(){
        return this.authors;
    }
    public  Author getAuthor(int id){
        for(Author author:this.authors){
            if(author.getId()==id){
                return author;
            }
        }
        return null;
    }
    public Author addAuthor(Author author){
        this.authors.add(author);
        return author;
    }
    public Author updateAuthor(int id, Author author){
        for(Author temp:this.authors){
            if(temp.getId()==id){
                temp.setName(author.getName());
                temp.setEmail(author.getEmail());
                return temp;
            }
        }
        return null;
    }
    public Author deleteAuthor(int id){
        for(Author temp:this.authors){
            if(temp.getId()==id){
                return this.authors.remove(this.authors.indexOf(temp));
            }
        }
        return null;
    }
}
