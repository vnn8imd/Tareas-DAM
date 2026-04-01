
//Escribir y leer enteros secuencialmente 

//Objetivo: 
//Practicar la apertura de un archivo binario, escritura de enteros y lectura secuencial. 

//Enunciado: 
//1. Crea un programa que abra (o cree) el archivo nums.bin en modo lectura/escritura. 
//2. Pide por pantalla los 5 numeros (enteros) favoritos del usuario y escribelos en el fichero.  
//3. Vuelve el puntero al inicio y lee los 5 enteros, imprimiéndolos por consola. 
//Utiliza únicamente RandomAccessFile y sus métodos básicos. 
//¿Qué valor devuelve getFilePointer() después de escribir los 5 enteros?


package com.digitech.mavenproject2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomAccessFile_EJ_1 {

     public static void main(String[] args) throws IOException { //Declaramos main para que pueda lanzar IOException
        try (Scanner sc = new Scanner(System.in); //Abre un Scanner para leer desde teclado (se cierra solo)       
//1. Crea un programa que abra (o cree) el archivo nums.bin en modo lectura/escritura. 
            RandomAccessFile raf = new RandomAccessFile("nums.bin", "rw")) {     
//2. Pide por pantalla los 5 numeros (enteros) favoritos del usuario y escribelos en el fichero. 
            for (int i = 1; i<=5; i++) {
            System.out.print("Introduce tu entero favorito" + i +": ");
            int num = sc.nextInt();
            raf.writeInt(num); //Escribe el int (ocupa 4 byttes) y avanza el puntero.
            }           
            //Opcional
            long posDespues = raf.getFilePointer(); //Guarda la posición del puntero tras escribir los 5 números.
            System.out.println("getFilePointer() tras escribir = " + posDespues + " bytes"); //Muestra la posición (debería ser 20)            
//3. Vuelve el puntero al inicio y lee los 5 enteros, imprimiéndolos por consola.   
            raf.seek(0); //Mueve el puntero al byte 0 (inicio del archivo)
            System.out.println("/nLeyendo de vuelta los 5 enteros");
            for (int i = 0; i < 5; i++){ //Bucle de lectura de 5 enteros
            int n = raf.readInt(); //Lee 4 bytes como int y avanza el puntero
                System.out.println("[" + i + "] = " + n); //Imprime el valor leído
            }    
        }   //Fin del try-with-resources: cierra Scanner y RandomAccessFile        
    }
}     
 




