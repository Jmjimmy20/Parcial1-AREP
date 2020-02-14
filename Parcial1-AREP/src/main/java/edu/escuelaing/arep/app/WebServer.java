package edu.escuelaing.arep.app;

import spark.Request;
import spark.Response;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.List;


public class WebServer{

    //static ArrayList<Float> listaNumeros=new ArrayList<Float>(); 
    static Calculadora calculadora = new Calculadora();

    public static void main(String[] args){
        port(getPort());
         //get("/hello", (req, res) -> "Hello Heroku");
         get("/main", (req, res) -> mainPage(req, res));
         get("/results", (req, res) -> resultsPageSort(req, res));
    }

    private static String mainPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<center>"
                + "<h1>PARCIAL 1</h1>"
                + "<h2>AREP 2020-1</h2>"
                + "<h2>Jimmy Moya</h2>"
                + "<h3>Ingrese los numeros a operar</h3>"
                + "<form action=\"/results\">"
                + "  Ingrese los números separados por coma(,):<br>"
                + "  <input type=\"text\" name=\"num\" placeholder=\"Ej. 1,2,3\">"
                + "  <br>"
                + "  <br> <br>"                  
                + "  <input type=\"submit\" value=\"Enviar\">"
                + "</form>"
                + "</center>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultsPageSort(Request req, Response res) {
        
        String[] a=req.queryParams("num").split(",");
        String respuesta ="" ;
        List<Double> dataList = new ArrayList<Double>();
        for(int i=0;i<a.length;i++){
            dataList.add(Double.parseDouble(a[i]));
        } 
        List<Double> listAux = calculadora.Ordenar(dataList);
        
        for(int i = 0; i<listAux.size();i++){
            respuesta = respuesta +","+ listAux.get(i).toString();
        }
        

        String pageContent 
                = "<!DOCTYPE html>" + "<html>" + "<body>" 
                + "<center>" + "<h2>Resultado</h2>"
                + "<h3> Ordenada: " + respuesta + "</h3>"
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