// TAREA 1: BUCLE WHILE

let nombreWhile = prompt("WHILE - Introduce tu nombre:");
let nWhile = parseInt(prompt("WHILE - Introduce un número entero para repetir:"));

if (nombreWhile && !isNaN(nWhile) && nWhile > 0) {
    document.write("<h2>Tarea 1 (WHILE): Imprimiendo el nombre " + nWhile + " veces</h2>");
    
    let contadorWhile = 1;
    while (contadorWhile <= nWhile) {
        document.write("<p>" + contadorWhile + ". " + nombreWhile + "</p>");
        contadorWhile++; // Incremento crucial para evitar un bucle infinito
    }
} else {
    document.write("<p style='color: red;'>Error: Debes introducir un nombre y un número positivo.</p>");
}