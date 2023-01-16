/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webserver.webserver.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.webserver.webserver.config.com.webserver.webserver.util.Json;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.webserver.webserver.config.Configuration;
import static com.webserver.webserver.config.com.webserver.webserver.util.Json.fromJson;

/**
 *
 * @author Pichau
 */
public class ConfigurationManager {
    private static ConfigurationManager myConfigurationManager; //O motivo pelo qual nós estamos criando apenas um Configuration manager é pelo fato de não precisarmos de mais de um, ele será compartilhado por tudo ao redor do projeto
    private static Configuration myCurrentConfiguration;
    
    private ConfigurationManager() {
    }
    
    
    private static ConfigurationManager getInstance(){
        if(myConfigurationManager == null){
            myConfigurationManager = new ConfigurationManager(); // Se não houver um configurationManager, um novo configurationmanager será criado
        }
        return myConfigurationManager;
        }
    
    /* Vai carregar um arquivo de configuração baseado no caminho provido
    
   */          
    public void LoadConfigurationfile(String caminhodoArquivo) throws FileNotFoundException, IOException{
        FileReader leitor = new FileReader(caminhodoArquivo);
        StringBuffer sb = new StringBuffer();
        int i = leitor.read();
        while(i != -1){
            sb.append((char)i);
        
    }
        JsonNode conf = Json.parse(sb.toString());
        Object x = Json.fromJson(conf, Configuration.class);
        myConfigurationManager = (ConfigurationManager) x;
}
    /* Vai retornar a configuração já provida e carregada
    
    */
    public void getCurrentConfiguration() throws IOException{
        
    }
}
