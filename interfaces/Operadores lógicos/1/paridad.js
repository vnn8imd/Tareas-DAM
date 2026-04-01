// 1. Obtener referencias de los elementos del DOM
const form = document.getElementById('paridadForm');
const inputNumero = document.getElementById('inputNumero');
const resultadoSpan = document.getElementById('resultado');

/**
 * Función para procesar el formulario y la lógica de la tarea.
 * @param {Event} event - El evento de envío del formulario.
 */
function comprobarNumero(event) {
    // Evita que el formulario recargue la página, esencial para apps modernas
    event.preventDefault(); 
    
    // Obtener y convertir el valor de entrada a un número entero
    const numero = parseInt(inputNumero.value);

    // ====================================================================
    // 2. Definición de la Condición de ERROR (usando operadores lógicos OR)
    // El número es "inválido" si:
    // a) No es un número (isNaN) O
    // b) Es igual a 0 O
    // c) Es menor que 0
    // ====================================================================
    const esNumeroInvalido = isNaN(numero) || numero === 0 || numero < 0;

    // 3. Uso del Operador NOT (!) para la Comprobación
    // El bloque IF se ejecuta solo si la condición NO es "inválido"
    if (!esNumeroInvalido) {
        // A) SI SE CUMPLE LA CONDICIÓN (es positivo y distinto de cero)
        
        let mensaje;
        
        // Comprobar si es par o impar (operador módulo %)
        if (numero % 2 === 0) {
            mensaje = `El número **${numero}** es **PAR** (Divisible por 2).`;
            resultadoSpan.className = 'exito'; // Aplicar estilo de éxito
        } else {
            mensaje = `El número **${numero}** es **IMPAR** (No divisible por 2).`;
            resultadoSpan.className = 'exito'; // Aplicar estilo de éxito
        }
        
        resultadoSpan.textContent = mensaje;

    } else {
        // B) SI NO SE CUMPLE LA CONDICIÓN (es inválido, cero o negativo)
        
        // Mostrar mensaje de error
        const mensajeError = "ERROR: El valor introducido no es válido. Debe ser un número entero mayor que cero.";
        resultadoSpan.textContent = mensajeError;
        resultadoSpan.className = 'error'; // Aplicar estilo de error
    }
}

// 4. Asignar el "Escuchador de Eventos" al formulario
form.addEventListener('submit', comprobarNumero);