// TAREA: Diseñar un array de imágenes y mostrar la imagen solicitada por el usuario.
// Implementación con Rutas Locales (Método estándar y accesible).

// 1. Array de objetos con las rutas relativas a las imágenes

const imagenesArray = [
    { nombre: "gato", url: "img/gato.webp", alt: "Fotografía de un gato sentado." },
    { nombre: "perro", url: "img/perro.webp", alt: "Fotografía de un perro labrador." },
    { nombre: "pajaro", url: "img/pajaro.webp", alt: "Fotografía de un pájaro." },
    { nombre: "pez", url: "img/pez.webp", alt: "Fotografía de un pez." },
    { nombre: "arbol", url: "img/arbol.webp", alt: "Fotografía de un árbol." } 
];

// Función principal que maneja la búsqueda y la impresión de la imagen
function buscarEImprimirImagen(event) {
    event.preventDefault(); // Detiene el envío del formulario

    // Obtiene el valor del input, lo convierte a minúsculas y elimina espacios
    const inputNombre = document.getElementById('inputImagen').value.toLowerCase().trim();
    const contenedor = document.getElementById('contenedorResultado');
    
    // Limpiar el contenido anterior
    contenedor.innerHTML = "";
    
    // Buscar la imagen en el array usando el método .find()
    const imagenEncontrada = imagenesArray.find(img => img.nombre === inputNombre);

    if (imagenEncontrada) {
        // --- Implementación Accesible: Manipulación del DOM ---
        
        const imgElemento = document.createElement('img');
        imgElemento.src = imagenEncontrada.url;
        imgElemento.alt = imagenEncontrada.alt; // Atributo ALT (CRUCIAL para WCAG 1.1.1)
        
        // Estilos para visualización
        imgElemento.style.maxWidth = '300px';
        imgElemento.style.height = 'auto';
        imgElemento.style.border = '2px solid green';
        
        // Insertar la imagen en el contenedor
        contenedor.appendChild(imgElemento);
        
        // Mensaje de éxito
        contenedor.innerHTML += `<p class='exito'>Mostrando imagen: **${imagenEncontrada.nombre.toUpperCase()}**</p>`;
        
    } else {
        // Mensaje de error
        contenedor.innerHTML = `<p class='error'>Error: La imagen con el nombre "${inputNombre}" no fue encontrada. Intenta con: gato, perro, pajaro, pez, o arbol.</p>`;
    }
}

// Inicializar la escucha de eventos al cargar el DOM
document.addEventListener('DOMContentLoaded', () => {
    const formulario = document.getElementById('formImagen');
    formulario.addEventListener('submit', buscarEImprimirImagen);
});