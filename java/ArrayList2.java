package com.digitech.arraylist2;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList2 {

    public static void main(String[] args) {
        
/**
1.Crear un arraylist con 5 valores de tipo integer. 
Calcular la media de todos los valores. 
Visualizar todos los valores y la media. 
2.Realiza un programa donde almacenamos los nombres de animales, dichos nombres se 
almacenan en un Arraylist. Se piden valores hasta que se teclea la palabra SALIR. 
Visualizar los valores, y el número de valores que se introducen. 
**/

        ArrayList <Integer> valores=new ArrayList<>();
        
        valores.add(58);
        valores.add(82);
        valores.add(100);
        valores.add(15);
        valores.add(7);
        
//Para calcular la media se suman todos los valores y se dividen entre 5.        
        
        // Variable para almacenar la suma
        
        int tSuma = 0;
              
       // Calcular la suma de todos los valores utilizando un bucle for tradicional

        for (int i = 0; i < valores.size(); i++) {
            tSuma += valores.get(i);  // Obtener el valor en la posición 'i' y sumarlo
        }

        // Calcular la media: La media se calcula dividiendo la suma entre la cantidad de elementos en el ArrayList, 
        //obtenida con lista.size(). Para asegurar una división con precisión decimal, usamos el cast a double en el divisor.
        
        double media = tSuma / (double) valores.size();  // Convertimos a double para obtener precisión decimal

        // Visualizar los valores en el ArrayList
        
        System.out.println("Los valores en el ArrayList son:");
        
        for (int i = 0; i < valores.size(); i++) 
        {
            System.out.print(valores.get(i) + " ");  // Mostrar cada valor
        }

        // Visualizar la suma y la media
        
        System.out.println("La suma de los valores es: " + tSuma);
        System.out.println("La media de los valores es: " + media);
        
//2.Realiza un programa donde almacenamos los nombres de animales, dichos nombres se almacenan en un Arraylist. Se piden valores hasta que se teclea la palabra SALIR.
//Visualizar los valores, y el número de valores que se introducen. 

        ArrayList <String> animals = new ArrayList<>();
              
        Scanner dataanimal = new Scanner(System.in);
        String nombre;

        System.out.println("Introduce los nombres de los animales (escribe 'salir' para terminar):");
        
        while (true) {
        nombre = dataanimal.nextLine();
        if (nombre.equalsIgnoreCase("salir")) 
        {
        break;
        }
        animals.add(nombre);
        }

        System.out.println("Los nombres de los animales introducidos son:");
        
        for (int i = 0; i<animals.size();i++) 
        {
    // Accede al elemento por su índice
        System.out.println(animals.get(i)); 
        }
    // Imprimir el número total de animales introducidos
        System.out.println("Número total de animales introducidos: " + animals.size());
        
        
    }
}
    
        


   
