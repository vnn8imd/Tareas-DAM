// TAREA: Manejo de Array con bucles FOR y WHILE, de forma ACCESIBLE.

// Función principal que crea y llena el array
function crearArrayPorPosicion(numCeldas) {
    const contenedor = document.getElementById('contenedorArray');
    
    // 1. Validación (WCAG 3.3.1 - Identificación de Errores)
    if (isNaN(numCeldas) || numCeldas <= 0) {
        contenedor.innerHTML = "<p class='error'>Error: Por favor, introduce un número entero positivo para las celdas.</p>";
        return null;
    }

    const arrayDatos = [];
    
    // 2. Si hay 10 celdas, cada celda guarda su posición.
    if (numCeldas === 10) {
        // Usamos el bucle FOR para llenar el array
        for (let i = 0; i < 10; i++) {
            // El array guarda el número correspondiente a su posición (índice)
            arrayDatos[i] = i; 
        }
        return arrayDatos;
    } else {
        // En un caso real, aquí se llenaría el array con otro criterio o se daría un mensaje.
        contenedor.innerHTML = "<p class='error'>Advertencia: El programa solo procesa arrays de 10 celdas con la lógica de guardar la posición.</p>";
        return null;
    }
}


// Función para imprimir un array usando el bucle FOR
function imprimirArrayFor(array, contenedor) {
    let htmlContent = "<h3>Impresión con Bucle FOR:</h3><ul>";
    
    if (array) {
        for (let i = 0; i < array.length; i++) {
            // Salida estructurada como lista (WCAG 1.3.1 - Información y Relaciones)
            htmlContent += `<li>Posición [${i}]: ${array[i]}</li>`;
        }
    }
    htmlContent += "</ul>";
    contenedor.innerHTML += htmlContent;
}


// Función para imprimir un array usando el bucle WHILE
function imprimirArrayWhile(array, contenedor) {
    let htmlContent = "<h3>Impresión con Bucle WHILE:</h3><ul>";
    
    if (array) {
        let i = 0;
        // Bucle WHILE
        while (i < array.length) {
             // Salida estructurada como lista (WCAG 1.3.1)
            htmlContent += `<li>Posición [${i}]: ${array[i]}</li>`;
            i++; // Incrementar crucial para evitar bucle infinito
        }
    }
    htmlContent += "</ul>";
    contenedor.innerHTML += htmlContent;
}


// Función de control para capturar la entrada del formulario
function capturarDimensionesArray(event) {
    event.preventDefault(); 
    
    const inputCeldas = document.getElementById('inputCeldasArray').value;
    const numCeldas = parseInt(inputCeldas);
    
    const contenedor = document.getElementById('contenedorArray');
    // Limpiar el contenido anterior
    contenedor.innerHTML = "";

    const miArray = crearArrayPorPosicion(numCeldas);
    
    if (miArray && miArray.length === 10) {
        imprimirArrayFor(miArray, contenedor);
        imprimirArrayWhile(miArray, contenedor);
    }
}

// Inicializar la escucha de eventos al cargar el DOM
document.addEventListener('DOMContentLoaded', () => {
    const formulario = document.getElementById('formArray');
    formulario.addEventListener('submit', capturarDimensionesArray);
});