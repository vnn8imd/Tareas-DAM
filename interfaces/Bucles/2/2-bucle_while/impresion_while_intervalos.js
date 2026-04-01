// TAREA: Imprimir números del 1 al 100, en intervalos de 10 en 10, usando WHILE.

function imprimirIntervalosWhile() {
    // 1. Obtener la referencia al elemento donde se mostrará el resultado
    const contenedor = document.getElementById('resultadoIntervalos');
    let listaHTML = "<ul>";
    
    // Inicialización de la variable de control
    let i = 1;

    // Bucle WHILE: Se ejecuta mientras i sea menor o igual a 100.
    while (i <= 100) { 
        // 2. Concatenar el contenido en una lista
        listaHTML += `<li>Número: ${i}</li>`;
        
        // 3. Incremento crucial para el intervalo de 10 y para evitar bucle infinito
        i += 10; 
    }

    listaHTML += "</ul>";
    
    // 4. Actualizar el contenido del contenedor usando manipulación del DOM
    if (contenedor) {
        contenedor.innerHTML = "<h2>Secuencia Generada con WHILE (1-100 en pasos de 10)</h2>" + listaHTML;
        contenedor.className = 'exito';
    }
}

// Ejecutar la función cuando el documento esté completamente cargado
document.addEventListener('DOMContentLoaded', imprimirIntervalosWhile);