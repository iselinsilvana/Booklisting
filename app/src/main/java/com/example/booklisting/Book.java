package com.example.booklisting;

public class Book {
    private String mTitle;
    private String mAuthors;


    public Book(String title, String authors) {
        mTitle = title;
        mAuthors = authors;
    }

    public String getBookTitle() {return mTitle;}
    public String getBookAuthors() {return mAuthors;}


}