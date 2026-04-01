// La tasa de conversión: 1 Euro = 0.87 Libras
const TASA_CONVERSION = 0.87;

// 1. Pedir al usuario el importe en Euros mediante una ventana prompt
let importeEuros = prompt("Introduce el importe en Euros (€) para convertirlo a Libras (£):");

// 2. Comprobar si el usuario introdujo un valor (no pulsó 'Cancelar')
if (importeEuros !== null) {
    // 3. Convertir la entrada a un número decimal (float)
    // Usamos parseFloat para manejar posibles decimales.
    let euros = parseFloat(importeEuros);

    // 4. Verificar si la entrada es un número válido y positivo
    if (!isNaN(euros) && euros >= 0) {
        // 5. Calcular la equivalencia en Libras
        let importeLibras = euros * TASA_CONVERSION;

        // 6. Imprimir el resultado en el documento HTML
        document.write("<h2>Conversión de Moneda</h2>");
        document.write("<p>Importe introducido: **" + euros.toFixed(2) + " Euros (€)**</p>");
        // toFixed(2) asegura que el resultado tenga dos decimales
        document.write("<p>Tasa de conversión: **1€ = " + TASA_CONVERSION + "£**</p>");
        document.write("<p>Equivalencia en Libras: **" + importeLibras.toFixed(2) + " Libras (£)**</p>");

    } else {
        // 7. Manejo de error si la entrada no es un número válido o es negativa
        alert("Error: Por favor, introduce un número válido y positivo.");
        document.write("<p>No se pudo realizar la conversión. Por favor, recarga la página e introduce un valor numérico válido.</p>");
    }
} else {
    // 8. Manejo si el usuario pulsa 'Cancelar'
    document.write("<p>El usuario canceló la operación de conversión.</p>");
}