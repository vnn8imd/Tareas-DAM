
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CrearDirectoriosFicheros {
    public static void main(String[] args) {
        //Ruta completa donde quieres crear el directorio
        String rutaBase = "C:\\AD\\EJERCICIOS"; // ruta donde quieres crear el directorio EJ_1

        //Crear el directorio principal (si no existe)
        File miDir = new File(rutaBase);
        if (!miDir.exists()) {
            boolean ok = miDir.mkdirs(); // mkdirs() crea todos los niveles necesarios
            if (ok) {
                System.out.println("Directorio creado: " + miDir.getAbsolutePath());
            } else {
                System.out.println("No se pudo crear el directorio.");
            }
        } else {
            System.out.println("El directorio ya existe: " + miDir.getAbsolutePath());
        }
        //Crear archivo dentro del directorio
        File archivo = new File(miDir, "miFichero.txt");
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getAbsolutePath());

                // (Opcional) Escribir algo en el archivo
                try (FileWriter fw = new FileWriter(archivo)) {
                    fw.write("Archivo creado en una ruta específica.\n");
                    fw.write("¡¡Hola lo conseguiste maquinita!!\n");
                }

            } else {
                System.out.println("El archivo ya existe: " + archivo.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Error al crear o escribir el archivo:");
            e.printStackTrace();
        }
    }
}    
