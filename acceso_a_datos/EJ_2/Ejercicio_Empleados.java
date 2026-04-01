import java.io.*;

public class Ejercicio_Empleados {
    public static void main(String[] args) {

        // Ruta del archivo
        String ruta = "C:\\AD\\Ejercicios\\Empleados.txt";

        //️Escribir los empleados en el archivo
        try {
            
            try ( 
                    FileWriter fw = new FileWriter(ruta); 
                    BufferedWriter bw = new BufferedWriter(fw)) {
                
                // Escribimos 10 empleados (ID y nombre)
                for (int i = 1; i <= 10; i++) {
                    String linea = i + " - Empleado_" + i;
                    bw.write(linea);
                    bw.newLine(); // salto de línea
                }
                
            }
            System.out.println("Archivo 'Empleados.txt' creado y escrito correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

                //Leer el archivo y mostrar su contenido
        try {
           
            try ( 
                    FileReader fr = new FileReader(ruta); 
                    BufferedReader br = new BufferedReader(fr) 
            ) {
                
                System.out.println("\nContenido del archivo 'Empleados.txt':\n");
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
                
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

    
