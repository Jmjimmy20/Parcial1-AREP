package edu.escuelaing.arep.app;

import java.io.*;
import java.net.*;

public class Cliente{

    public static void main(String[] args) throws Exception {

        
        
        
        /**
        * pagina main del web server donde se piden los datos        
        */
        URL url1 = new URL("ttps://serene-mesa-21204.herokuapp.com/main");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url1.openStream()))) {

            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);            
            }   
        } catch (IOException x) {
            System.err.println(x);
        }
        
        
        /**
        * Lee la segunda pagina del web server con un ejemplo de haber insertado la lista que contiene los números 1 2 3  
        */
        System.out.println("JSON RESULTADO:");
        URL url2 = new URL("https://serene-mesa-21204.herokuapp.com/results?num=1%2C2%2C3");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url2.openStream()))) {

            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);            
            }   
        } catch (IOException x) {
            System.err.println(x);
        }
       }

}