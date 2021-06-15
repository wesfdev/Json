package com.greencity.model;

import java.util.ArrayList;
import java.util.List;

public class WebSite {
    
    private Integer id;
    private String name;
    private List<Book> books;

    public WebSite() {
        this.books = new ArrayList<>();
    }

    public WebSite(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    public void addBook(Book book){
        if(this.books == null){
            this.books = new ArrayList<>();
        }
        this.books.add(book);
    }
    
    public boolean isBookExist(String author, String title) throws Exception{
        if(author == null){
            throw new Exception("Invalid author");
        }
        
        if(title == null){
            throw new Exception("Invalid title");
        }        
        
        for(Book book: this.books){
            Boolean existAuthor = equals(author, book.getAuthor());
            Boolean existTitle = equals(title, book.getBookTitle());
            if(existAuthor && existTitle){
                return Boolean.TRUE;
            }
        }
        
        return Boolean.FALSE;
    }
    
    private Boolean equals(String first, String second){
        return first.equalsIgnoreCase(second);
    }
}
