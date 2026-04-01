// TAREA 1: BUCLE FOR

let nombreFor = prompt("FOR - Introduce tu nombre:");
let nFor = parseInt(prompt("FOR - Introduce un número entero para repetir:"));

if (nombreFor && !isNaN(nFor) && nFor > 0) {
    document.write("<h2>Tarea 1 (FOR): Imprimiendo el nombre " + nFor + " veces</h2>");
    for (let i = 1; i <= nFor; i++) {
        document.write("<p>" + i + ". " + nombreFor + "</p>");
    }
} else {
    document.write("<p style='color: red;'>Error: Debes introducir un nombre y un número positivo.</p>");
}