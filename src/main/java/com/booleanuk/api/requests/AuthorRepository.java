package com.booleanuk.api.requests;

import java.util.ArrayList;

//Model
public class AuthorRepository {
    private final ArrayList<Author> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<>(){
            {
                add(new Author("JRR Tolkien","jrr@tolkien.com"));
                add(new Author("George RR Martin", "george@martin.com"));
                add(new Author("Charles Dickens","charles@dickens.com"));
            }
        };
    }

    public ArrayList<Author> getAll() {
        return this.authors;
    }

    public Author getOne(int id) {
        for (Author author: this.authors){
            if (author.getId() == id){
                return author;
            }
        }
        return null;
    }

    public Author addAuthor(Author author) {
        this.authors.add(author);
        return author;
    }

    public Author editAuthor(int id, Author author) {
        for (Author anotherAuthor: this.authors){
            if (anotherAuthor.getId() == id){
                anotherAuthor.setName(author.getName());
                anotherAuthor.setEmail(author.getEmail());
                return anotherAuthor;
            }
        }
        return null;
    }

    public Author deleteAuthor(int id){
        int index = -1;
        for (int i=0; i<=this.authors.size(); i++){
            if (this.authors.get(i).getId() == id){
                index = i;
                break;
            }
        }
        if (index == -1){
            return null;
        } else {
            return this.authors.remove(index);
        }
    }
}
