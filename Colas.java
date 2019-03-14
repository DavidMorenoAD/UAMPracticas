/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

import java.util.Random;

/**
 * Autor: Moreno Gutiérrez David
 * version 23/11/2017
 * Colas
 */
public class Colas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cola<Integer> listaDeEnteros = new Cola<>();
        int enteroAleatorio;
        
        for(int i=0; i < 20; i++){
            Random generadorAleatorios = new Random();
            enteroAleatorio = generadorAleatorios.nextInt(1000);
            listaDeEnteros.insertar(enteroAleatorio);
            
        }
        
        listaDeEnteros.mostrarCola();
        listaDeEnteros.borrar();
        listaDeEnteros.mostrarCola();
        listaDeEnteros.tamañoCola();
    }
    
}
