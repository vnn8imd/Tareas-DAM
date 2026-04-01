// TAREA: Crear una tabla con dimensiones definidas por el usuario, usando FOR, de forma ACCESIBLE.

// 1. Función principal que se encargará de crear y adjuntar la tabla.
function crearTablaFor(filas, celdas) {
    // Referencia al contenedor en el HTML donde se mostrará la tabla
    const contenedor = document.getElementById('contenedorTabla');
    
    // Validar la entrada (mantenemos la lógica de validación)
    if (isNaN(filas) || isNaN(celdas) || filas <= 0 || celdas <= 0) {
        contenedor.innerHTML = "<p class='error'>Error: Por favor, introduce números positivos para filas y celdas.</p>";
        return;
    }

    // Limpiar el contenedor y añadir un título
    contenedor.innerHTML = "<h2>Tabla Generada con Bucle FOR (" + filas + "x" + celdas + ")</h2>";
    
    // Crear el elemento <table> (Manipulación del DOM)
    const tabla = document.createElement('table');
    tabla.setAttribute('border', '1');
    tabla.style.width = '50%';
    tabla.style.borderCollapse = 'collapse';

    // Bucle exterior: FILAS (r)
    for (let r = 1; r <= filas; r++) {
        const fila = document.createElement('tr'); // Crear elemento <tr>

        // Bucle interior: CELDAS (c)
        for (let c = 1; c <= celdas; c++) {
            const celda = document.createElement('td'); // Crear elemento <td>
            celda.style.padding = '10px';
            celda.style.textAlign = 'center';
            celda.textContent = "Fila " + r + ", Celda " + c;
            
            fila.appendChild(celda); // Añadir la celda a la fila
        }
        tabla.appendChild(fila); // Añadir la fila a la tabla
    }
    
    // Añadir la tabla al contenedor principal
    contenedor.appendChild(tabla); 
}


// 2. Función de control para capturar la entrada del formulario
function capturarDimensiones(event) {
    // Previene el envío del formulario (fundamental para accesibilidad)
    event.preventDefault(); 
    
    // Obtener los valores del formulario
    const inputFilas = document.getElementById('inputFilas').value;
    const inputCeldas = document.getElementById('inputCeldas').value;
    
    // Llamar a la función de creación con los valores capturados
    crearTablaFor(parseInt(inputFilas), parseInt(inputCeldas));
}

// 3. Inicializar la escucha de eventos al cargar el DOM
document.addEventListener('DOMContentLoaded', () => {
    const formulario = document.getElementById('formTabla');
    formulario.addEventListener('submit', capturarDimensiones);
});