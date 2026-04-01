document.addEventListener('DOMContentLoaded', () => {
    // 1. Seleccionar el formulario y añadir el event listener
    const form = document.getElementById('notasForm');
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Detiene el envío del formulario para manejarlo con JS
        
        // 2. Obtener los valores del formulario
        const nombre = document.getElementById('nombre').value;
        const apellido1 = document.getElementById('apellido1').value;
        const apellido2 = document.getElementById('apellido2').value;
        
        // Las notas deben convertirse a números
        const nota1 = parseFloat(document.getElementById('nota1').value);
        const nota2 = parseFloat(document.getElementById('nota2').value);
        const nota3 = parseFloat(document.getElementById('nota3').value);

        // 3. Realizar los cálculos y evaluaciones
        
        // Calcular el promedio
        const promedio = (nota1 + nota2 + nota3) / 3;
        const promedioRedondeado = promedio.toFixed(2); // Redondear a 2 decimales
        
        // Determinar el calificativo
        const calificativo = obtenerCalificativo(promedio);
        
        // Evaluar la promoción (Prácticas/Repetir/Pendientes)
        const evaluacion = evaluarPromocion(nota1, nota2, nota3, nombre, apellido1, apellido2);

        // 4. Mostrar los resultados en la interfaz
        document.getElementById('datosAlumno').textContent = `Alumno: ${nombre} ${apellido1} ${apellido2}`;
        document.getElementById('promedioFinal').textContent = `Promedio Final: ${promedioRedondeado}`;
        document.getElementById('calificativo').textContent = `Calificativo: ${calificativo}`;
        
        // 5. Mostrar el alert de promoción
        alert(evaluacion.alerta);
    });

    /**
     * Función para determinar el calificativo según el promedio.
     * @param {number} p - El promedio de las notas.
     * @returns {string} El calificativo correspondiente.
     */
    function obtenerCalificativo(p) {
        if (p === 10) {
            return "MATRÍCULA DE HONOR";
        } else if (p >= 9) {
            return "SOBRESALIENTE"; // 9 - 9.9
        } else if (p >= 7) {
            return "NOTABLE"; // 7 - 8.9
        } else if (p >= 5) {
            return "APROBADO"; // 5 - 6.9
        } else {
            return "SUSPENSO"; // 0 - 4.9
        }
    }
    
    /**
     * Función para evaluar la promoción a prácticas o repetición.
     * @param {number} n1 - Nota 1.
     * @param {number} n2 - Nota 2.
     * @param {number} n3 - Nota 3.
     * @returns {object} Objeto con el mensaje de alerta.
     */
    function evaluarPromocion(n1, n2, n3, nom, ap1, ap2) {
        const notas = [n1, n2, n3];
        let suspensos = 0;
        let asignaturasPendientes = [];
        
        // Contar el número de asignaturas suspensas (nota < 5)
        notas.forEach((nota, index) => {
            if (nota < 5) {
                suspensos++;
                asignaturasPendientes.push(`Asignatura ${index + 1} (${nota.toFixed(1)})`);
            }
        });

        let mensajeAlerta = "";
        
        // Reglas de promoción
        if (suspensos === 0) {
            mensajeAlerta = `${nom} ${ap1}, ¡Felicidades! Todas las asignaturas aprobadas. Puede iniciar su período de prácticas.`;
        } else if (suspensos === 1) {
            const listaPendientes = asignaturasPendientes.join(', ');
            mensajeAlerta = `${nom} ${ap1}, lleva ${listaPendientes} pendiente. No podrá hacer las prácticas hasta que apruebe la asignatura.`;
        } else if (suspensos >= 2) { // Incluye 2 y 3 suspensos
            mensajeAlerta = `${nom} ${ap1}, debe repetir el curso, ya que tiene ${suspensos} asignaturas suspensas.`;
        }
        
        return { alerta: mensajeAlerta };
    }
});