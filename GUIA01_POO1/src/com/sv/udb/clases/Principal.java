/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Estudiante
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        try {
            String cadena, Iniciales = "";
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            while((cadena = b.readLine())!=null) {
            String[] split = cadena.split(" ");
            for (String inicial : split) {
                Iniciales = Iniciales + inicial.charAt(0) + ".";
            }   
            System.out.println("Sus iniciales son: " + Iniciales.toUpperCase());
            }
            b.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
      
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        boolean cerrar = false;
        do {
            try {
                System.out.println("Ingrese el numero de la opción para escogerla:");
                System.out.println("1. Ejercicio1 - Nombre y sus iniciales.");
                System.out.println("2. Ejercicio2 - Nombre y sus iniciales en archivo txt.");
                System.out.println("3. Ejercicio3 - Primer numero repetido 3 veces.");
                System.out.println("4. Ejercicio4 - Lanzamiento de un dado.");
                System.out.println("5. Salir (o cualquier otro número).");
                Scanner sc = new Scanner(System.in);
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        Ejercicio1();
                        break;
                    case 2:
                        Ejercicio2();
                        break;
                    case 3:
                        Ejercicio3();
                        break;
                    case 4:
                        Ejercicio4();
                        break;
                    default:
                        cerrar = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un problema, disculpe las molestias. " + e.getMessage());
            }
        } while (!cerrar);
    }
    
    private static void Ejercicio1() {
        Scanner Entrada = new Scanner(System.in);
        System.out.println("Escriba su nombre completo: ");
        String Nombre = Entrada.nextLine();
        String Iniciales = "";
        String[] split = Nombre.split(" ");
        for (String inicial : split) {
            Iniciales = Iniciales + inicial.charAt(0) + ".";
        }
        System.out.println("Sus iniciales son: " + Iniciales.toUpperCase());
        System.out.println("Enter para continuar...");
        Nombre = Entrada.nextLine();
        System.out.println("");
        
    }
    
    private static void Ejercicio2() {
        try {
            System.out.println("Ingrese su nombre completo en el archivo txt que esta fuera llamado 'nombres.txt'");
            Scanner sc = new Scanner(System.in);
            System.out.println("Escribe 'si' si ya terminaste: ");
            String Nombre = sc.nextLine();
            if ("si".equals(Nombre.toLowerCase())){
                muestraContenido("nombres.txt");
            }
            else
            {
                System.out.println("Intentolo de nuevo.");
            }
            System.out.println("Enter para continuar...");
            Nombre = sc.nextLine();
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private static void Ejercicio3() {
        Scanner sc = new Scanner(System.in);
        List<Integer> listaNumeros = new ArrayList<Integer>();
        int contador = 0, resultado = 0;
        do {
            System.out.println("Ingrese un numero entero: ");
            int numero = sc.nextInt();
            listaNumeros.add(numero);
            for (int x = 0; x < listaNumeros.size(); x++) {
                contador = 0;
                for (int i = 0; i < listaNumeros.size(); i++) {
                    if (listaNumeros.get(x) == listaNumeros.get(i)) {
                        contador++;
                    }
                    if (contador == 3) {
                        resultado = listaNumeros.get(x);
                    }
                }
            }
        } while (contador < 3);
        System.out.println("Numero repetido 3 veces: " + resultado);
        System.out.println("Enter para continuar...");
        sc = new Scanner(System.in);
        String continuar = sc.nextLine();
        System.out.println("");
    }
    
    private static void Ejercicio4(){
        System.out.println("Ingrese 'lanzar' para empezar a girar el dado:");
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        boolean bandera = false;
        System.out.println("Deje en blanco y presione enter para continuar. Ingrese un dato y presione enter para finalizar");
        if ("lanzar".equals(entrada.toLowerCase())) {
            do {
                for (int i = 0; i < 5; i++){
                    System.out.println("cara del dado: " + Math.round(Math.random()*5+1));
                }
                entrada = sc.nextLine();
                if (!(("").equals(entrada))) {
                    bandera = true;
                    System.out.println("Finalizado");
                }
            } while(bandera == false);
        }
        System.out.println("Enter para continuar...");
        sc = new Scanner(System.in);
        entrada = sc.nextLine();
        System.out.println("");
    }
    
    
    
}
