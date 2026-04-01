// 1. Configuración de rutas y datos
const rutaBase = 'C:/Users/vnn8i/OneDrive - Digitech/2 DAM/Vídeos Interfaces/Tareas Obligatorias/Visor/';

const datos = [
    { url: 'foto1.jpg', texto: 'Este es el titular de la imagen 1' },
    { url: 'foto2.jpg', texto: 'Este es el titular de la imagen 2' },
    { url: 'foto3.jpg', texto: 'Este es el titular de la imagen 3' },
    { url: 'foto4.jpg', texto: 'Este es el titular de la imagen 4' },
    { url: 'foto5.jpg', texto: 'Este es el titular de la imagen 5' },
    { url: 'foto6.jpg', texto: 'Este es el titular de la imagen 6' }
];

let indiceActual = 5; // Empezamos en la imagen 6 según el modelo

// 2. Selección del contenedor base
const main = document.getElementById('contenedor-principal');

// 3. Creación de Nodos mediante createElement 
const visorContenedor = document.createElement('div');
visorContenedor.className = 'visor-contenedor';

const imagenVisor = document.createElement('img');
imagenVisor.className = 'imagen-principal';

const capaTitular = document.createElement('div');
capaTitular.className = 'capa-titular';

// Flechas
const flechaIzq = document.createElement('img');
flechaIzq.src = rutaBase + 'flecha-correcta-izq.png';
flechaIzq.className = 'flecha izq';

const flechaDer = document.createElement('img');
flechaDer.src = rutaBase + 'flecha-correcta-der.png';
flechaDer.className = 'flecha der';

// Paginación (puntos)
const contenedorPuntos = document.createElement('div');
contenedorPuntos.className = 'contenedor-puntos';

// Crear los 6 puntos dinámicamente
const puntosArray = [];
for (let i = 0; i < datos.length; i++) {
    const punto = document.createElement('div');
    punto.className = 'punto';
    contenedorPuntos.appendChild(punto);
    puntosArray.push(punto);
}

// 4. Montaje del DOM (Append Child) 
visorContenedor.appendChild(flechaIzq);
visorContenedor.appendChild(imagenVisor);
visorContenedor.appendChild(capaTitular);
visorContenedor.appendChild(flechaDer);
visorContenedor.appendChild(contenedorPuntos);
main.appendChild(visorContenedor);

// 5. Función de actualización 
function actualizarVisor() {
    const item = datos[indiceActual];
    imagenVisor.src = rutaBase + item.url;
    capaTitular.textContent = item.texto;

    // Actualizar puntos de paginación
    puntosArray.forEach((p, index) => {
        p.classList.toggle('activo', index === indiceActual);
    });
}

// 6. Eventos de navegación
flechaDer.onclick = () => {
    indiceActual = (indiceActual + 1) % datos.length;
    actualizarVisor();
};

flechaIzq.onclick = () => {
    indiceActual = (indiceActual - 1 + datos.length) % datos.length;
    actualizarVisor();
};

// Carga inicial
actualizarVisor();