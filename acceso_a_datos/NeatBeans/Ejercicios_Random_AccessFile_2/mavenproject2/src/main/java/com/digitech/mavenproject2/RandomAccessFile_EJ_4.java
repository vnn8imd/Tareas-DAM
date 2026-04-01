// 4) Registros de tamaño fijo (id + nombre fijo) 

//Objetivo: 
    //Diseñar un registro binario de tamaño fijo para permitir acceso directo al registro n. 
//Enunciado: 
    //1. Define un registro con: id (int, 4 bytes) y nombre (10 chars, 20 bytes con writeChar) 
    //2. Escribe tres registros de ejemplo 
    //3. Lee directamente el tercer registro y muestra sus campos por consola.


package com.digitech.mavenproject2;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_EJ_4 {
    // Número de caracteres fijos para el nombre
    static final int NCHARS = 10; //El nombre ocupará exactamente 10 chars 3 usages
    //Tamaño del registro en bytes: id (4) + nombre (10 chars + 2 bytes) = 24
    static final int BYTES_REG = 4 + (2 * NCHARS); // 4 + 20 = 24 BYTES POR REGISTRO 4 USAGES
    
    public static void main (String[] args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile("personas.dat", "rw")){
            raf.setLength(0);
            
            //Escribir 3 registros de ejemplo ---->//Registro 0: id=1, nombre = "Vicente"
            
            raf.seek(0 * BYTES_REG);                        // Offset registro 0 = 0* 24 =0
            escribirRegistro(raf,'1', "Vicente");           //Escribimos id y nombre fijo
            
            raf.seek(1 * BYTES_REG);                        // Offset registro 1 = 1* 24 =24
            escribirRegistro(raf, 2, "María Ángeles");      //Escribimos id y nombre fijo
            
            raf.seek(2 * BYTES_REG);                        // Offset registro 2 = 2* 24 =48
            escribirRegistro(raf, 3, "Ángel");              //Escribimos id y nombre fijo (Este es el registro que tendremos que leer).
            
           //---- Leer directamente el tercer registro ----
           int indiceRegistro = 2;                          //Tercer registro (empezando en cero) --> índice 2
           long offset = (long) indiceRegistro * BYTES_REG; //Offset = 2 * 24 = 48
           raf.seek (offset);                               //Nos colocamos al inicio del tercer registro
           int id = raf.readInt();                          //Leemos el id (4 bytes)
           String nombre = leerNombreFijo (raf,NCHARS);     //Leemos 10 chars (20 bytes) y los convertimos a String
           
            System.out.println("Tercer registro --> id= " + id +", nombre=" + nombre);  // Mostramos el id y el nombre del tercer registro
           
            
        }
    }
    
//--FUNCIONES-- //Escribe un registro (id + nombre fijo) en la posición actual del puntero.

static void escribirRegistro(RandomAccessFile raf, int id, String nombre) throws IOException { 
            raf.writeInt(id); //Escribimos id (4 bytes)
            escribirNombreFijo(raf, nombre, NCHARS); //Escribimos nombre fijo de 10 caracteres (20 bytes)        
        }

//Escribe exactamente 'len' caracteres, recortando o rellenando con espacios
static void escribirNombreFijo(RandomAccessFile raf, String s, int len) throws IOException {
    if (s.length()!= len)
            s = String.format("%-" + len + "." + len + "s", s);
    for (int i = 0; i< len; i++) {
        raf.writeChar(s.charAt(i));
    }
    }
//Lee exactamente 'len' chars del fichero y devuelve el String sin espacios de relleno
    static String leerNombreFijo(RandomAccessFile raf, int len) throws IOException{
        StringBuilder sb = new StringBuilder(len);
        for (int i= 0; i< len; i++) {
            sb.append(raf.readChar()); 
        }
        return sb.toString().trim();
    }
}



