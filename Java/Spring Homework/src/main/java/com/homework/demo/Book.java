package com.homework.demo;

public class Book {
    private static int nextId = 0;

    private int id;

    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    private String title;
    private String author;
    private Integer releaseYear;

    public Book(String title, String author, Integer releaseYear) {
        this.id = nextId++;
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }
}