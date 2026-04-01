// TAREA: Crear una tabla con dimensiones definidas por el usuario, usando FOR.

function crearTablaFor() {
    // Pedir dimensiones al usuario
    let filas = parseInt(prompt("FOR - Introduce el número de FILAS (R):"));
    let celdas = parseInt(prompt("FOR - Introduce el número de CELDAS/COLUMNAS (C):"));

    // Validar la entrada
    if (isNaN(filas) || isNaN(celdas) || filas <= 0 || celdas <= 0) {
        document.write("<p style='color: red;'>Error: Por favor, introduce números positivos para filas y celdas.</p>");
        return;
    }

    // Inicializar la tabla y el estilo
    document.write("<h2>Tabla Generada con Bucle FOR (" + filas + "x" + celdas + ")</h2>");
    document.write("<table border='1' style='width: 50%; border-collapse: collapse;'>");

    // Bucle exterior: FILAS (r)
    for (let r = 1; r <= filas; r++) {
        document.write("<tr>");
        
        // Bucle interior: CELDAS (c)
        for (let c = 1; c <= celdas; c++) {
            document.write("<td style='padding: 10px; text-align: center;'>Fila " + r + ", Celda " + c + "</td>");
        }
        document.write("</tr>");
    }
    document.write("</table>");
}

// Ejecutar la función
crearTablaFor();