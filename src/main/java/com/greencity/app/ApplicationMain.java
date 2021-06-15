/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greencity.app;

import com.google.gson.JsonObject;
import com.greencity.model.Book;
import com.greencity.model.WebSite;
import com.greencity.service.WebSiteResource;
import com.greencity.util.JsonHelper;
import java.util.List;


/**
 *
 * @author usuario
 */
public class ApplicationMain {
    public static void main(String[] args) throws Exception {
        String filePath = "src/main/java/JSON/Json.json";
        WebSiteResource service = new WebSiteResource();
        
        service.loadWebSites(filePath);
        service.printAll();
        
        System.out.println("Exist book? " + service.isBookExist("Test1", "Pascal"));
        System.out.println("Exist book? " + service.isBookExist("Test500", "JS"));
    }
    
}
