package br.appCrud.appCrud.entities;

import javax.annotation.processing.Generated;


public class Book {
    private Integer id;
    private String name;
    private String author;

    // Builders
    public Book(){
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
