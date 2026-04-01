// 1. Obtener referencias de los elementos del DOM
const form = document.getElementById('analisisForm');
const inputNumero = document.getElementById('inputNumero');
const resultadoSpan = document.getElementById('resultado');

/**
 * Función para realizar el análisis numérico complejo.
 * @param {Event} event - El evento de envío del formulario.
 */
function analizarNumero(event) {
    // Detiene el envío estándar del formulario
    event.preventDefault(); 
    
    // Obtener el valor y convertirlo a un número entero
    const numero = parseInt(inputNumero.value);

    // Inicializar el mensaje de resultado y la clase CSS
    let mensaje = "";
    let clase = "";

    // ====================================================================
    // 2. Comprobación Inicial (Validación principal)
    // Debe ser un número válido (no NaN) Y positivo (> 0)
    // ====================================================================
    if (!isNaN(numero) && numero > 0) {
        
        // --- Condición a: Número de dos cifras (10 a 99) ---
        if (numero >= 10 && numero <= 99) {
            
            clase = 'exito';
            
            // a.1. Calcular si es par o impar
            if (numero % 2 === 0) {
                mensaje = `El número ${numero} es de dos cifras y es **PAR**.`;
            } else {
                mensaje = `El número ${numero} es de dos cifras y es **IMPAR**.`;
            }

        // --- Condición b: Número de tres cifras (100 a 999) ---
        } else if (numero >= 100 && numero <= 999) {
            
            clase = 'exito';
            
            // b.1. Mostrar el resto de dividir el número entre 2
            const resto = numero % 2;
            mensaje = `El número ${numero} es de tres cifras. El **resto de dividirlo entre 2 es: ${resto}**.`;

        } else {
            // El número es positivo y distinto de cero, pero no es de 2 ni de 3 cifras.
            clase = 'error';
            mensaje = `El número ${numero} es válido, pero no es de dos ni de tres cifras.`;
        }

    } else {
        // 3. Condición de ERROR (Si no se cumplen las condiciones iniciales)
        clase = 'error';
        mensaje = "ERROR: Por favor, introduce un número entero **positivo y distinto de cero**.";
    }

    // 4. Actualizar el DOM para mostrar el resultado
    resultadoSpan.textContent = mensaje;
    resultadoSpan.className = clase;
}

// 5. Asignar el "Escuchador de Eventos" al formulario
form.addEventListener('submit', analizarNumero);