// TAREA 1: BUCLE DO...WHILE

let nombreDoWhile = prompt("DO...WHILE - Introduce tu nombre:");
let nDoWhile = parseInt(prompt("DO...WHILE - Introduce un número entero para repetir:"));

if (nombreDoWhile && !isNaN(nDoWhile) && nDoWhile > 0) {
    document.write("<h2>Tarea 1 (DO...WHILE): Imprimiendo el nombre " + nDoWhile + " veces</h2>");
    
    let contadorDoWhile = 1;
    
    // El bucle se ejecuta al menos una vez, luego comprueba la condición.
    do {
        document.write("<p>" + contadorDoWhile + ". " + nombreDoWhile + "</p>");
        contadorDoWhile++;
    } while (contadorDoWhile <= nDoWhile);
    
} else {
    document.write("<p style='color: red;'>Error: Debes introducir un nombre y un número positivo.</p>");
}