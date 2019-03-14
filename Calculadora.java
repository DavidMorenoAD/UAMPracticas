/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;
import Excepciones.ExcepcionOpcionInvalida;
import java.util.InputMismatchException; 
import java.util.Scanner; 
import Excepciones.ExcepcionRaiz;

/**
 * Calculadora de dos numeros dobles con manejo de Excepciones
 * @author David Moreno Gutierrez
 * Version: 20/11/2017
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     * @throws Excepciones.ExcepcionRaiz
     */
    public static void main(String[] args) throws ExcepcionRaiz, ExcepcionOpcionInvalida {
        // Metodo principal donde se invocan los metodos de captura y donde está el menu principal
        
        double A, B;
        int opcion = 0;
        Scanner teclado = new Scanner (System.in);
        //Menu principal ciclado mientras la opcion sea distinta de 0
        
        do{
            System.out.println("\n¿Qué operación desea realizar ahora?");
            System.out.println("1.- Suma");
            System.out.println("2.- Resta");
            System.out.println("3.- Multiplicación");
            System.out.println("4.- División");
            System.out.println("5.- Elevar al Cuadrado");
            System.out.println("6.- Raiz Cuadrada");
            System.out.println("7.- Salir");
            //Excepcion para que solo se puedan introducir numeros enteros del 1 al 7 ciclada
            
            do{
                try{
                    opcion = capturaOpcion();
                    if(opcion <1 || opcion >7)
                        throw new Excepciones.ExcepcionOpcionInvalida("numero fuera del rango");
                }
                catch(Excepciones.ExcepcionOpcionInvalida opInvalida){
                    System.out.println("Opcion Invalida. Solo puede escoger un numero entero del 1 al 7");
                }
            }while(opcion <1 || opcion >7);
            // Casos dependiendo de la entrada (1-7) para realizar una operacion especifica
            switch(opcion){
                case 1:
                    //SUMA
                    
                    double suma;
                    do{
                        System.out.println("\nPrimer Valor (A)");
                        A = capturaValoresDobles();
                    }while(Double.isNaN(A)== true);
                    do{
                        System.out.println("\nSegundo Valor (B)");
                        B = capturaValoresDobles();
                    }while(Double.isNaN(B)== true);
                    suma = A + B;
                    System.out.println("La Suma de los valores " + A + " + " + B + " Es: " + suma);
                    break;
                case 2:
                    //RESTA
                    
                    double Resta;
                    do{
                        System.out.println("\nPrimer Valor (A)");
                        A = capturaValoresDobles();
                    }while(Double.isNaN(A)== true);
                    do{
                        System.out.println("\nSegundo Valor (B)");
                        B = capturaValoresDobles();
                    }while(Double.isNaN(B)== true);
                    Resta = A - B;
                    System.out.println("La Resta de los valores " + A + " - " + B + " Es: " + Resta);
                    break;
                case 3:
                    //MULTIPLICACION
                    
                    double Multiplicacion;
                    do{
                        System.out.println("\nPrimer Valor (A)");
                        A = capturaValoresDobles();
                    }while(Double.isNaN(A)== true);
                    do{
                        System.out.println("\nSegundo Valor (B)");
                        B = capturaValoresDobles();
                    }while(Double.isNaN(B)== true);
                    Multiplicacion = A * B;
                    System.out.println("La Multiplicacion de los valores " + A + " * " + B + " Es: " + Multiplicacion);
                    break;
                case 4:
                    //DIVISION
                    
                    double Division;

                        do{
                            System.out.println("\nPrimer Valor (A)");
                            A = capturaValoresDobles();
                        }while(Double.isNaN(A)== true);
                        do{
                            System.out.println("\nSegundo Valor (B)");
                            B = capturaValoresDobles();
                        }while(Double.isNaN(B)== true);
                        // Excepcion para la division entre 0
                        
                        try{
                            Division = A / B;
                        }catch(ArithmeticException division){
                            Division = Double.NaN;
                        }
                            System.out.println("La Division de los valores " + A + " / " + B + " Es: " + Division);
                    break;
                case 5:
                    //CUADRADO DE UN NUMERO
                    
                    double ElevarCuadrado;
                    do{
                        System.out.println("\nPrimer Valor (A)");
                        A = capturaValoresDobles();
                    }while(Double.isNaN(A)== true);
                    ElevarCuadrado = Math.pow(A, 2);
                    System.out.println("El numero " + A + " elevado al cuadrado es igual a " + ElevarCuadrado);
                    break;
                case 6:
                    // RAIZ CUADRADA
                    
                    double RaizCuadrada;
                    do{
                        do{
                            System.out.println("\nPrimer Valor (A)");
                            A = capturaValoresDobles();
                        }while(Double.isNaN(A)== true);
                        //Excepcion especial para el caso en el que se introduzca un numero negativo en una raiz
                        
                        try{
                            if (A < 0)
                                throw new ExcepcionRaiz("Numero negativo en Raiz");
                            RaizCuadrada = Math.sqrt(A);
                            }catch(Excepciones.ExcepcionRaiz RaizDeNegativo){
                                System.out.println("La solucion no existe en los numeros reales. Inserte un numero positivo");
                                RaizCuadrada = Double.NaN;
                            }
                        }while(Double.isNaN(RaizCuadrada)== true);
                    System.out.println("La Raiz cuadrada del numero " + A + " Es: " + RaizCuadrada);
                    break;
                default:
                    //OPCION ESPECIAL PARA SALIR DEL PROGRAMA
                    
                    System.out.println("\nBye");
                    break;
            }
        }while(opcion!=7);
    }
//MÉTODO PARA CAPTURAR UNA OPCION(NUMERO ENTERO) Y VALIDARLA
    
    private static int capturaOpcion() {
        int opcion = 0;
        Scanner teclado = new Scanner (System.in);
        //Excepcion para que solo se puedan introducir como entrada numeros Dobles  
        try{
            System.out.print("\nIntroduce el numero de la operacion a realizar:   ");
            opcion = teclado.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Error solo puede introducir valores numericos enteros.");
        }
        return opcion;
        }
//MÉTODO PARA CAPTURAR DATOS DE TIPO DOUBLE
    
    private static double capturaValoresDobles() {
        double X;
        Scanner teclado = new Scanner (System.in);
        //Excepcion para que solo se puedan introducir como entrada numeros Dobles
        try{
            System.out.print("Introdusca un Valor:  ");
            X = teclado.nextDouble();
        }catch(InputMismatchException e){
            X = Double.NaN;
            System.out.println("Valor invalido, introduzca solo numeros reales.");
        }
        return X;
        }
}
