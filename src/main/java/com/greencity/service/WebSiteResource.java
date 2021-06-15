/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greencity.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.greencity.model.Book;
import com.greencity.model.WebSite;
import com.greencity.util.JsonHelper;
import java.util.ArrayList;
import java.util.List;
import static com.greencity.util.JsonHelper.*;
import java.util.Map;

/**
 *
 * @author usuario
 */
public class WebSiteResource {

    private static final String ID = "id";
    private static final String BOOKS = "books";
    private static final String AUTHOR = "author";
    private static final String TITLE = "bookTitle";
    private static final String WEB_SITES = "websites";
    
    private List<WebSite> sites;
    
    public List<WebSite> loadWebSites(String filePath) throws Exception {
        JsonObject resource = getJsonResource(filePath);
        JsonArray websites = getArray(resource, WEB_SITES);
        List<WebSite> response = new ArrayList<>();
        for (JsonElement element : websites) {
            for (Map.Entry entry : element.getAsJsonObject().entrySet()) {
                String name = (String) entry.getKey();
                JsonObject site = (JsonObject) entry.getValue();
                WebSite webSite = makeWebSite(name, site);
                response.add(webSite);
            }
        }
        this.sites = response;
        return response;
    }
    
    private JsonObject getJsonResource(String filePath) throws Exception{
        return JsonHelper.makeJsonObject(filePath);
    }

    private WebSite makeWebSite(String name, JsonObject object) {
        WebSite site = new WebSite();
        site.setName(name);
        site.setId(getIntValue(object, ID));
        List<Book> books = loadBooks(getArray(object, BOOKS));
        site.setBooks(books);
        return site;
    }

    private List<Book> loadBooks(JsonArray booksArray) {
        List<Book> books = new ArrayList<>();
        for (JsonElement item : booksArray) {
            Book book = makeBook(item.getAsJsonObject());
            books.add(book);
        }

        return books;
    }

    private Book makeBook(JsonObject object) {
        Book book = new Book();
        book.setAuthor(getValue(object, AUTHOR));
        book.setBookTitle(getValue(object, TITLE));
        return book;
    }
    
    public void printAll(){
        System.out.println("----------------------------------------------------");
        for(WebSite site: sites){
            System.out.println("Site: "+ site.getId() + " - " + site.getName());
            for(Book book: site.getBooks()){
                System.out.println(" Book: " + book.getAuthor() + " - " + book.getBookTitle());
            }
        }    
        System.out.println("----------------------------------------------------");        
    } 
    
    public Boolean isBookExist(String author, String title) throws Exception{
        for(WebSite site: sites){
            Boolean existBook = site.isBookExist(author, title);
            if(existBook){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

}
