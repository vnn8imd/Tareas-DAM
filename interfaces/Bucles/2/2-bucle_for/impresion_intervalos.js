// TAREA: Imprimir números del 1 al 100, en intervalos de 10 en 10.

function imprimirIntervalos() {
    const contenedor = document.getElementById('resultadoIntervalos');
    let listaHTML = "<ul>";

    // Bucle FOR corregido: 
    // Ahora el límite superior es 100, pero el último valor impreso será 91.
    for (let i = 1; i <= 100; i += 10) { 
        listaHTML += `<li>Número: ${i}</li>`;
    }

    listaHTML += "</ul>";
    
    if (contenedor) {
        contenedor.innerHTML = "<h2>Secuencia Generada (1-100 en pasos de 10)</h2>" + listaHTML;
        contenedor.className = 'exito';
    }
}

document.addEventListener('DOMContentLoaded', imprimirIntervalos);