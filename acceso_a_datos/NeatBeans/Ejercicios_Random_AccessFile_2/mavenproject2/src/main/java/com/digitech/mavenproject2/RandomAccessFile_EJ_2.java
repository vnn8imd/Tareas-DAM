//Acceso directo a posiciones fijas (slots de 4 bytes) 

//Objetivo: 
//Entender el acceso aleatorio calculando offsets a partir del tamaño de un tipo primitivo. 

//Enunciado: 
//1. Crea un archivo llamado slots.bin. 
//2. Escribe los enteros del ejercicio anterior de modo que cada uno quede en su 'slot' de 4 bytes. 
//3. Lee solo el segundo valor, sin leer los demás, y muéstralo por consola. 

package com.digitech.mavenproject2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomAccessFile_EJ_2 {
   public static void main (String[] arg) throws IOException { //main puede lanzar IOException y no hace falta que ponga el Cath
       try (Scanner sc = new Scanner(System.in); // Scanner para entrada estándar (se cierra solo)
            RandomAccessFile raf = new RandomAccessFile ("slots.bin","rw")) { // 1.Abre/crea slots.bin en rw
            raf.setLength(0); //Deja el archivo vacío (empezamos de cero)
    // Pedir por teclado 5 enteros y escribir cada uno en su "slot" de 4 bytes (modo aleatorio, no secuencial)
            for (int i=0; i < 5; i++) { //Repetimos 5 veces
                System.out.println("Introduce tu número entero favorito" + (i + 1) + ": "); //Solicitud de numero entero favorito al usuario
                int n = sc.nextInt(); // Lee un entero del teclado (variable n es numero)
                long offset = i * 4L; // Cada numero int ocupa 4 bytes --> (slot i empieza en i*4)
                raf.seek(offset);  //Mueve el puntero al inicio del slot i
                raf.writeInt(n);  //Escribe el int (4 bytes) en ese slot   
            }
    //Lee solo el segundo valor, sin leer los demás, y muéstralo por consola. 
            raf.seek(1 * 4L);  // Segundo slot --> byte 4
            int segundo = raf.readInt(); //Lee 4 bytes como int (sólo ese de la segunda posición)
            System.out.println("Segundo valor=" + segundo); //Muestra el resultado          
       }   //try-with-resources cierra Scanner y RAF
   } 
}
