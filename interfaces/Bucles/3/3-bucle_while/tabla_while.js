// TAREA: Crear una tabla con dimensiones definidas por el usuario, usando WHILE, de forma ACCESIBLE.

// 1. Función principal que se encargará de crear y adjuntar la tabla.
function crearTablaWhile(filas, celdas) {
    // Referencia al contenedor en el HTML donde se mostrará la tabla
    const contenedor = document.getElementById('contenedorTabla');
    
    // Validar la entrada
    if (isNaN(filas) || isNaN(celdas) || filas <= 0 || celdas <= 0) {
        contenedor.innerHTML = "<p class='error'>Error: Por favor, introduce números positivos para filas y celdas.</p>";
        return;
    }

    // Limpiar el contenedor y añadir un título
    contenedor.innerHTML = "<h2>Tabla Generada con Bucle WHILE (" + filas + "x" + celdas + ")</h2>";
    
    // Crear el elemento <table> (Manipulación del DOM)
    const tabla = document.createElement('table');
    tabla.setAttribute('border', '1');
    tabla.style.width = '50%';
    tabla.style.borderCollapse = 'collapse';

    let r = 1;
    // Bucle exterior: FILAS
    while (r <= filas) {
        const fila = document.createElement('tr'); // Crear elemento <tr>

        let c = 1; 
        // Bucle interior: CELDAS
        while (c <= celdas) {
            const celda = document.createElement('td'); // Crear elemento <td>
            celda.style.padding = '10px';
            celda.style.textAlign = 'center';
            celda.textContent = "Fila " + r + ", Celda " + c;
            
            fila.appendChild(celda); // Añadir la celda a la fila
            c++;
        }
        tabla.appendChild(fila); // Añadir la fila a la tabla
        r++;
    }
    
    // Adjuntar la tabla al contenedor principal
    contenedor.appendChild(tabla); 
}


// 2. Función de control para capturar la entrada del formulario (reemplazo de prompt())
function capturarDimensiones(event) {
    // Previene el envío del formulario tradicional, manteniendo la página estable
    event.preventDefault(); 
    
    // Obtener los valores del formulario
    const inputFilas = document.getElementById('inputFilas').value;
    const inputCeldas = document.getElementById('inputCeldas').value;
    
    // Llamar a la función de creación con los valores capturados
    crearTablaWhile(parseInt(inputFilas), parseInt(inputCeldas));
}

// 3. Inicializar la escucha de eventos al cargar el DOM
document.addEventListener('DOMContentLoaded', () => {
    const formulario = document.getElementById('formTabla');
    formulario.addEventListener('submit', capturarDimensiones);
});