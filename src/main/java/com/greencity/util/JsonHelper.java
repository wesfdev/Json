/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greencity.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author usuario
 */
public class JsonHelper {

    public JsonHelper() throws Exception {
        throw new Exception("Helper class");
    }

    public static JsonObject makeJsonObject(String filePath) throws Exception {
        try {
            FileReader reader = new FileReader(filePath);
            Gson gson = new Gson();
            return gson.fromJson(reader, JsonObject.class);
        } catch (FileNotFoundException e) {
            throw new Exception("File Not found", e);
        }
    }
    
    public static String getValue(JsonObject object, String property){
        return object.get(property).getAsString();
    }
    
    public static Integer getIntValue(JsonObject object, String property){
        return object.get(property).getAsInt();
    }    
    
    public static JsonArray getArray(JsonObject object, String property){
        return object.get(property).getAsJsonArray();
    }      

}
