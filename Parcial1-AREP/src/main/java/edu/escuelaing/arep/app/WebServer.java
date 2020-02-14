package edu.escuelaing.arep.app;

import spark.Request;
import spark.Response;
import static spark.Spark.*;
import java.util.ArrayList;


public class WebServer{

    static ArrayList<Float> lista=new ArrayList<Float>(); 
    static Calculadora calculadora = new Calculadora();

    public static void main(String[] args){
        port(getPort());
         //get("/hello", (req, res) -> "Hello Heroku");
         get("/main", (req, res) -> mainPage(req, res));
         get("/results", (req, res) -> resultsPage(req, res));
    }

    private static String mainPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h1>PARCIAL 1</h1>"
                + "<h2>AREP 2020-1</h2>"
                + "<h2>Jimmy Moya</h2>"
                + "<h3>Ingrese los numeros a operar</h3>"
                + "<form action=\"/results\">"
                + "  Ingrese los números separados por un espacio:<br>"
                + "  <input type=\"text\" name=\"num\" placeholder=\"Ej. 1 2 3\">"
                + "  <br>"
                + "  <br> <br>"                  
                + "  <input type=\"submit\" value=\"Enviar\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
        //realizar proceso y llamar a la siguiente pagina 

        String pageContent 
                = "<!DOCTYPE html>" + "<html>" + "<body>" 
                + "<center>" + "<h2>Resultados</h2>"
                + "<h3> Promedio: " + "mean" + "</h3>"
                + "<h3> Desviacion Estandar: " + "standard" + "</h3>"
                + "</center>" + "</body>" + "</html>";
        return pageContent;
    }


    static int getPort() {
        if (System.getenv("PORT") != null) { 
           return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost) 
    }

}