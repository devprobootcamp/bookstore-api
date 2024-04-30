package com.devpro.bookstore.dto;

public class Book {

    private String title;
    private String ibns;
    private String author;

    public Book(String title, String ibns, String author) {
        this.title = title;
        this.ibns = ibns;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIbns() {
        return ibns;
    }

    public void setIbns(String ibns) {
        this.ibns = ibns;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
