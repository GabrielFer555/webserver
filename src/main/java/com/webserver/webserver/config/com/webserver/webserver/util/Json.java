/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webserver.webserver.config.com.webserver.webserver.util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
/**
 *
 * @author Pichau
 */
public class Json {
    private static ObjectMapper myObjectMapper = newDefaultObjectMapper();
    
    private static ObjectMapper newDefaultObjectMapper(){
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, false);
        return om;
        
    }
    
    /*Criando um jeito de passar uma String em JSon para um Node Json*/
    public static JsonNode parse(String Json) throws IOException{
        return myObjectMapper.readTree(Json);
    } 
    /*Criando um metodo para converter o arquivo convertido acima para o arquivo .java*/
    
    public static <A> A fromJson(JsonNode node, Class <A> clazz)throws JsonProcessingException{
        return myObjectMapper.treeToValue(node, clazz);
    }
    public static JsonNode toJson(Object x){
        return myObjectMapper.valueToTree(x);
    }
    /**/
    public static String stringnify(JsonNode node) throws JsonProcessingException{
        return Json.generateJson(node, false);
    }
    
    public static String stringnifypretty(JsonNode node) throws JsonProcessingException{
        return Json.generateJson(node, false);
    }
    
    private static String generateJson(Object x, boolean pretty) throws JsonProcessingException{
        ObjectWriter z = myObjectMapper.writer();
        if(pretty){
            z = z.with(SerializationFeature.INDENT_OUTPUT);
        }
        
        
        return z.writeValueAsString(x);
        
    }
    
}
