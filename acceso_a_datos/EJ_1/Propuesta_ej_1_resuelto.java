package vt01;                          // No es necesario, solo sirve para declarar que esta clase pertenece al paquete vt01, para que quede mas ordenado.

import java.io.File;                  // Importa la clase File.
import java.io.IOException;           // Importa la excepción de E/S que puede lanzar createNewFile().

public class Ejercicio01 {           

    public static void main(String args[]) {

        File miDirectorio = new File("src/vt01/miDirectorio"); // Crea un objeto File que APUNTA a la ruta "src/vt01/miDirectorio". Importante: aquí todavía NO se crea físicamente el directorio.
        File miFichero = new File("src/vt01/miDirectorio/miFichero.txt"); // Otro objeto File que apunta al fichero dentro del directorio anterior. Tampoco se crea aún el fichero; solo se referencia la ruta.

        try {                                   // Inicio de un bloque que puede lanzar IOException.

            miDirectorio.mkdir();               // Intenta crear el directorio (un único nivel). Devuelve true si lo crea y false si ya existía o si falla (por permisos, ruta inexistente, etc.).

            if (miFichero.createNewFile())      // Intenta crear físicamente el fichero. Devuelve true si lo crea; false si YA EXISTE.
                System.out.println("Fichero creado correctamente"); // Mensaje cuando createNewFile() devuelve true.

            else
                System.out.println("ERROR: No se ha podido crear el fichero"); // Mensaje cuando createNewFile() devuelve false (p.ej. ya existía o no pudo crearse).

            // El if/else no es necesario para crear el fichero en sí, solo lo ponemos para que quede mas profesional y muestre mas información por consola.

        } catch (IOException e) {               // Captura la IOException que puede lanzar createNewFile().
            System.out.println("Error al crear el fichero: " + e.getMessage()); // Imprime por pantalla mensaje de error corto
            // Una alternativa a la línea anterior es escribir directamente el siguiente método: e.printStackTrace();
            // El método e.printStackTrace() imprime la traza completa del error en la salida de errores. Útil para depuración: muestra clase, método y línea exacta del fallo.
        }

        System.out.println("FIN DEL PROGRAMA"); // Mensaje optativo de cierre, solo informativo.
    }
}
