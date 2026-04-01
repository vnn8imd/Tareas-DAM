package com.digitech.mavenproject2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomAccessFile_Tarea_Obl_4 {
    //Tamaño fijo del nombre: 20 chars
    static final int NCHARS = 20; //20 caracteres 4 usages
    //Tamaño del registro: id(4) + nombre(20*2=40) + edad(4) = 48 bytes
    static final int BYTES_REG = 4 + 2 * NCHARS + 4; //2usages
    
    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in);
                RandomAccessFile raf = new RandomAccessFile("personas2.dat", "rw")) {
            
            if (raf.length()==0) {  //Si el archivo está vacío
                //escribimos 3 registros de ejemplo
                escribirRegistro(raf,1,"Ana", 30); //reg 0
                escribirRegistro(raf,2,"Luis", 30); //reg 1
                escribirRegistro(raf,3,"María", 30); //reg 2
            }
            
            System.out.println("Introduce ID a actualizar: "); //Pedir id a actualizar
            int idBuscado = sc.nextInt();                     //Leer id
            
            System.out.println("Nueva edad: ");               //Pedir nueva edad
            int nuevaEdad = sc.nextInt();                     //Leer edad
            
            //1) Buscar secuencialmente el registro por id
            long numRegs = raf.length() / BYTES_REG;          //Número total de registros
            long regInicio = -1;                              //Offset (byte) donde empieza el registro encontrado
            for (int i = 0; i < numRegs; i++){                //Recorrer registros con el for
                    long offset = (long) i * BYTES_REG ;      //Inicio de registro i
                    raf.seek(offset);                         //Mover puntero a inicio reg i
                    int id = raf.readInt();                   //Leer id (4 bytes)
                    if (id == idBuscado){                     //¿Coincide?
                        regInicio = offset;                   //Guardar inicio del registro
                        break;
                    }
                    //Si no coincide, saltamos el resto del registro actual:
                    //nombre (40 bytes) + edad (4 bytes) ya quedarían "leídos" si avanzamos.
                    //pero como volvemos al for y recalculamos offset, basta con continuar                        
            }
            
            if (regInicio == -1){                             //Si no se encontró el id
                System.out.println("ID no encontrado.");      //Aviso
                return;                                       //Terminar    
            }
            
            //Actualizar SOLO el campo edad dentro del registro
            long offsetEdad = regInicio + 4 /*id*/ + (2L * NCHARS)/*nombre 408*/;   //4+40*44
            raf.seek(offsetEdad);                                                   //Puntero a campo edad
            raf.writeInt(nuevaEdad);                                                //Escribir nueva edad (5 bytes)
            
            //Verificación: leer el registro completo desde su inicio
            raf.seek(regInicio);                                                    //Volver al inicio del registro
            int id = raf.readInt();                                                 //Leer id
            String nombre = leerNombreFijo(raf, NCHARS);                            //Leer nombre (20 chars) y trim
            int edad = raf.readInt();                                               //Leer edad
            System.out.println("Actualizado: id=" + id + 
                    "nombre=" + nombre + "edad=" + edad);                           //Mostrar resultado
            }
        }
    
        //Escribe un registro completo en la posición actual del puntero
        
        static void escribirRegistro(RandomAccessFile raf, int id, String nombre, int edad) throws IOException {
            raf.writeInt(id);

            String fijo = String.format("%-" + NCHARS + "." + NCHARS + "s", nombre);

            for (int i = 0; i < NCHARS; i++) {                                      //Escribir 20 chars
            raf.writeChar(fijo.charAt(i));                                          //Cada char = 2 bytes
            }

            raf.writeInt(edad);
        }

        //Lee exactamente 'len' chars y hace trim() al final
        
        static String leerNombreFijo(RandomAccessFile raf, int len) throws IOException {
            StringBuilder sb = new StringBuilder(len);                              //Buffer

            for (int i = 0; i < len; i++) {                                         //Leer 20 chars
            sb.append(raf.readChar());                                              //readChar lee 2 bytes
        }

            return sb.toString().trim();                                            //Quitar relleno
    }
}
    










    
