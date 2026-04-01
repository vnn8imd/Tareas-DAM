/**
 * Clase que define la estructura del objeto Estudiante
 */
class Estudiante {
    constructor(nombre, apellido, edad, curso, foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.curso = curso;
        this.foto = foto;
    }
}

// Creamos el array con los 6 objetos utilizando tus imágenes
const listadoAlumnos = [
    new Estudiante("Cristina", "López", 24, "2º DAM", "alumna1.jpg"),
    new Estudiante("Manuel", "Guzmán", 18, "1º DAM", "alumno2.png"),
    new Estudiante("Mónica", "Ariza", 26, "2º DAW", "alumna3.jpg"),
    new Estudiante("Cristina", "López", 24, "2º DAM", "alumna1.jpg"),
    new Estudiante("Manuel", "Guzmán", 18, "1º DAM", "alumno2.png"),
    new Estudiante("Mónica", "Ariza", 26, "2º DAW", "alumna3.jpg")
];

// Función para renderizar los objetos en el HTML
function mostrarAlumnos() {
    const contenedor = document.getElementById('contenedor-alumnos');

    listadoAlumnos.forEach(alumno => {
        // Creamos el elemento div para cada ficha
        const fichaDiv = document.createElement('div');
        fichaDiv.className = 'ficha';

        // Estructura de contenido usando Template Literals
        fichaDiv.innerHTML = `
            <img src="${alumno.foto}" alt="${alumno.nombre}">
            <p><span class="etiqueta">Nombre:</span> <span class="valor">${alumno.nombre}</span></p>
            <p><span class="etiqueta">Apellido:</span> <span class="valor">${alumno.apellido}</span></p>
            <p><span class="etiqueta">Edad:</span> <span class="valor">${alumno.edad}</span></p>
            <p><span class="etiqueta">Curso:</span> <span class="valor">${alumno.curso}</span></p>
        `;

        // Agregamos la ficha al contenedor principal
        contenedor.appendChild(fichaDiv);
    });
}

// Ejecutamos la función al cargar la página
window.onload = mostrarAlumnos;