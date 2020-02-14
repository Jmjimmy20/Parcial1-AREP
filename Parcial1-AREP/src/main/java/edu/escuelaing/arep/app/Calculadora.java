package edu.escuelaing.arep.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class Calculadora{

    public Calculadora(){

    }

    public static <T extends Comparable<T>> int comparar(T dato1, T dato2) {
            
        //compara dato 1 con dato 2
        // retorna -1 si es menor, 0 si es igual, 1 si es mayor
        return dato1.compareTo(dato2); 
    }

    public <T extends Comparable<T>> List<T> Ordenar(List<T> lista) {
        int n = lista.size();
        List<T> temp = new ArrayList<T>();
        lista = mergeHelper(lista, 0,n,temp);
        return lista;
        
    }

    private static <T extends Comparable<T>> List<T>  mergeHelper(List<T> lista1, int from, int to, List<T> listaTemp) {
        
        if(from<to){
            int m = (from + to)/2;
            mergeHelper(lista1,from,m,listaTemp);
            mergeHelper(lista1, m +1, to, listaTemp);
            lista1=merge(lista1,from,m,to,listaTemp);
        }
        return lista1;
        
    }

    private static <T extends Comparable<T>> List<T>  merge(List<T> lista1, int from,int m, int to, List<T> listaTemp) {
        
        int i = from;
        int j= m +1;
        int k = from;

        while(i<= m && j<=to){
            if(comparar(lista1.get(i), lista1.get(j)) == -1){
                listaTemp.add(k, lista1.get(i));
                i++;
            }
            else{
                listaTemp.add(k, lista1.get(j));
                j++;
            }
            k++;
        }

        while(i<= m){
            listaTemp.add(k, lista1.get(i));
            i++;
            k++;
        }
        while(j<= to){
            listaTemp.add(k, lista1.get(j));
            j++;
            k++;
        }

        for(k=from;k<=to;k++){
            lista1.add(k,listaTemp.get(k));
        }

        return lista1;
        
    }




}