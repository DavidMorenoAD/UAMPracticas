/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;
import java.util.Random;
import java.util.Random;


/**
 * Autor: Moreno Gutiérrez David
 * Version; 25/11/2017
 * Pilas
 */
public class Pilas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // En el main solo hice una prueba para verificar los metodos de mi clase Pila
        
        Pila<Integer> listaDeEnteros = new Pila<>();
        int enteroAleatorio;
        
        for(int i=0; i < 6; i++){
            Random generadorAleatorios = new Random();
            enteroAleatorio = generadorAleatorios.nextInt(1000);
            listaDeEnteros.insertar(enteroAleatorio);
            
        }
        
        listaDeEnteros.mostrarLista();
        listaDeEnteros.borraElemento();
        listaDeEnteros.mostrarLista();
        listaDeEnteros.tamañoPila();
        
    }
    
}
