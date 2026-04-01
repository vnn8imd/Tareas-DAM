package com.digitech.tarea_2;

//1) Crea un programa en Java que permita gestionar archivos y directorios mediante un menú de opciones.
  //Usa la clase File y, cuando sea necesario, FileWriter o BufferedWriter para escribir en el archivo.
  //El programa trabajará en la ruta C:\AD\Ejercicios\Tarea_2 y deberá cumplir las siguientes funciones:

    //1) Crear un directorio llamado nuevoDirectorio.
    //2) Crear un fichero de texto llamado fichero_de_texto2.txt dentro de ese directorio.
    //3) Eliminar el fichero fichero_de_texto.txt del ejercicio anterior (ubicado en C:\AD\Ejercicios\Variante2).
    //4) Eliminar el directorio nuevoDirectorio, aunque contenga archivos o subdirectorios.
    //5) Introducir en el fichero fichero_de_texto2.txt la lista de las provincias de Andalucía, una por línea.
    //6) Salir del programa.

  //El menú debe repetirse hasta que el usuario elija la opción “Salir”.


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;      
   
        
public class Tarea_2 {

    // Ruta base del ejercicio actual
    private static final String RUTA_BASE = "C:\\AD\\Ejercicios\\Tarea_2";
    // Ruta del ejercicio anterior (Variante2)
    private static final String RUTA_VARIANTE2 = "C:\\AD\\EJERCICIOS\\VARIANTE2\\nuevoDirectorio";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;
            
            do {
                System.out.println("\n=== MENÚ DE GESTIÓN DE ARCHIVOS Y DIRECTORIOS ===");
                System.out.println("1. Crear directorio 'nuevoDirectorio'");
                System.out.println("2. Crear fichero 'fichero_de_texto2.txt'");
                System.out.println("3. Eliminar fichero 'fichero_de_texto.txt' de Variante2");
                System.out.println("4. Eliminar directorio 'nuevoDirectorio' (aunque contenga archivos)");
                System.out.println("5. Escribir provincias de Andalucía en 'fichero_de_texto2.txt'");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                
                switch (opcion) {
                    case 1 -> crearDirectorio();
                    case 2 -> crearFichero();
                    case 3 -> eliminarFicheroAnterior();
                    case 4 -> eliminarDirectorio();
                    case 5 -> escribirProvincias();
                    case 6 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
                
            } while (opcion != 6);
        }
    }

    // Opción 1: Crear directorio
    private static void crearDirectorio() {
        File dir = new File(RUTA_BASE + "\\nuevoDirectorio");
        if (dir.exists()) {
            System.out.println("El directorio ya existe.");
        } else if (dir.mkdirs()) {
            System.out.println("Directorio creado correctamente: " + dir.getAbsolutePath());
        } else {
            System.out.println("Error al crear el directorio.");
        }
    }

    // Opción 2: Crear fichero dentro del directorio
    private static void crearFichero() {
        try {
            File archivo = new File(RUTA_BASE + "\\nuevoDirectorio\\fichero_de_texto2.txt");
            if (archivo.exists()) {
                System.out.println("El fichero ya existe.");
            } else if (archivo.createNewFile()) {
                System.out.println("Fichero creado correctamente: " + archivo.getAbsolutePath());
            } else {
                System.out.println("Error al crear el fichero.");
            }
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    // Opción 3: Eliminar fichero de Variante2
    private static void eliminarFicheroAnterior() {
        File archivo = new File(RUTA_VARIANTE2 + "\\fichero_de_texto.txt");
            if (archivo.exists()) {
            if (archivo.delete()) {
            System.out.println("Fichero eliminado correctamente.");
            } else {
            System.out.println("No se pudo eliminar el fichero.");
            }
        } else {
            System.out.println("El fichero no existe en la ruta especificada.");
    }
}

    // Opción 4: Eliminar directorio con contenido
    private static void eliminarDirectorio() {
        File dir = new File(RUTA_BASE + "\\nuevoDirectorio");
        if (!dir.exists()) {
            System.out.println("El directorio no existe.");
            return;
        }
        eliminarRecursivo(dir);
        System.out.println("Directorio eliminado correctamente.");
    }

    private static void eliminarRecursivo(File file) {
        if (file.isDirectory()) {
            File[] archivos = file.listFiles();
            if (archivos != null) {
                for (File f : archivos) {
                    eliminarRecursivo(f);
                }
            }
        }
        file.delete();
    }

    // Opción 5: Escribir provincias de Andalucía en el fichero
    private static void escribirProvincias() {
        String[] provincias = {
                "Almería", "Cádiz", "Córdoba", "Granada",
                "Huelva", "Jaén", "Málaga", "Sevilla"
        };

        File archivo = new File(RUTA_BASE + "\\nuevoDirectorio\\fichero_de_texto2.txt");
        if (!archivo.exists()) {
            System.out.println("El fichero no existe. Primero créelo (opción 2).");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String provincia : provincias) {
                bw.write(provincia);
                bw.newLine();
            }
            System.out.println("Provincias escritas correctamente en el fichero.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}
