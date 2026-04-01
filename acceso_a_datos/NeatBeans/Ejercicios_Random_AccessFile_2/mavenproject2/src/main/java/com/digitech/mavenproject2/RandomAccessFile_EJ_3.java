//Cadenas cortas con writeUTF/readUTF 

//Objetivo: 

    //Guardar y recuperar varias cadenas usando los métodos UTF de DataInput/DataOutput. 

//Enunciado: 
    //1. Crea el archivo nombres.bin y escribe tres nombres cortos usando writeUTF. 
    //2. Vuelve al inicio con seek(0) y recupéralos con readUTF, mostrando cada nombre en una línea. 
    //3. Explica por qué no puedes saltar directamente al segundo nombre sin leer el primero.

package com.digitech.mavenproject2;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_EJ_3 {
    public static void main (String [] arg) throws IOException { //main puede lanzar IOException y no hace falta que ponga el Cath
        try (RandomAccessFile raf = new RandomAccessFile ("nombres.bin", "rw")){ //Abre/Crear el fichero de nombres de lectura y escritura
            raf.setLength(0); // Deja el fichero vacío si tiene datos para empezar de cero.
            // Escribimos 3 nombres con writeUTF (Porque son STRING/CARACTERES)
            raf.writeUTF("Vicente"); //Escribe "Vicente" en formato UTF (longitud+bytes)
            raf.writeUTF("María de los Ángeles"); //Escribe "María de los Ángeles" en formato UTF (longitud+bytes)
            raf.writeUTF("Ángel"); //Escribe "Ángel" en formato UTF (longitud+bytes)
            
            //En este punto el puntero se encuentra al final del archivo.
            
            //Ponemos el puntero al principio:
            raf.seek(0);
            
            //Leemos 3 veces con readUTF y mostramos cada nombre en una línea:
            
            String nombre1= raf.readUTF(); //readUTF lee primero la longitud y luego los bytes del texto
            System.out.println(nombre1); //Mostramos/imprimimos por pantalla el primer nombre
            
            String nombre2= raf.readUTF(); //readUTF lee primero la longitud y luego los bytes del texto
            System.out.println(nombre2); //Mostramos/imprimimos por pantalla el segundo nombre
            
            String nombre3= raf.readUTF(); //readUTF lee primero la longitud y luego los bytes del texto
            System.out.println(nombre3); //Mostramos/imprimimos por pantalla el tercer nombre
            
            //Para mostrar donde quedó el puntero al final:
            
            long finalPos = raf.getFilePointer(); //Para conseguir la posición del puntero tras leer los 3 nombres
            System.out.println("getFilePointer() al final = " + finalPos);       
        }
    }
}
