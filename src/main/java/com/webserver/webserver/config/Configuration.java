/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webserver.webserver.config;
//Essa classe aqui vai ser utilizada para mapear o arquivo JSON 
/**
 *
 * @author Pichau
 */
public class Configuration {
    private int port;
    private String webroot;

    public Configuration() {
    }

    public Configuration(int port, String webroot) {
        this.port = port;
        this.webroot = webroot;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getWebroot() {
        return webroot;
    }

    public void setWebroot(String webroot) {
        this.webroot = webroot;
    }

}
