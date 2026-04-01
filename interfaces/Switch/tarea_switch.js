// TAREA SWITCH: Lógica de Menús anidados con enfoque accesible.
// Versión FINAL usando Rutas Locales para garantizar la coherencia temática.

// 1. Definición de las RUTAS LOCALES Y ALT TEXTS (¡Asegúrate que estas imágenes existan en la carpeta 'img'!)
const IMAGENES = {
    perdida: { url: "img/perdida.jpg", alt: "Dibujo de una persona pensando, lamentando haber dicho NO." },
    paris: [
        { url: "img/paris1.jpg", alt: "Torre Eiffel en París." },
        { url: "img/paris2.jpg", alt: "Calles antiguas de París." },
        { url: "img/paris3.jpg", alt: "Museo famoso de París." }
    ],
    marsella: [
        { url: "img/marsella1.jpg", alt: "Puerto viejo de Marsella." },
        { url: "img/marsella2.jpg", alt: "Barcos en el Mediterráneo en Marsella." },
        { url: "img/marsella3.jpg", alt: "Paisaje costero de Marsella." }
    ],
    lyon: [
        { url: "img/lyon1.jpg", alt: "Río Saona a su paso por Lyon." },
        { url: "img/lyon2.jpg", alt: "Arquitectura moderna de Lyon." },
        { url: "img/lyon3.jpg", alt: "Calles históricas de Lyon." }
    ],
    // ESPAÑA
    es_playa: [
        { url: "img/es_playa1.jpg", alt: "Playa de arena dorada en España." },
        { url: "img/es_playa2.jpg", alt: "Costa española con acantilados." },
        { url: "img/es_playa3.jpg", alt: "Tumbonas en la playa de España." }
    ],
    es_montana: [
        { url: "img/es_montana1.jpg", alt: "Pico de montaña nevado en España." },
        { url: "img/es_montana2.jpg", alt: "Sendero en la montaña en España." }
    ],
    // PORTUGAL
    pt_turismo: [{ url: "img/pt_turismo1.jpg", alt: "Vista panorámica de Lisboa, Portugal." }],

    pt_playa: [
        { url: "img/pt_playa1.jpg", alt: "Playa de El Algarve con rocas." },
        { url: "img/pt_playa2.jpg", alt: "Cueva marina en El Algarve, Portugal." }
    ],
    pt_montana: [
        { url: "img/pt_montana1.jpg", alt: "Vistas de la costa o el santuario de Fátima, Portugal." },
        { url: "img/pt_montana2.jpg", alt: "Edificio histórico que representa a Fátima/Nazaret." }
    ]
};

// Párrafo de prueba (4 líneas aproximadamente)
const LOREM = "Lorem ipsum dolor sit amet consectetur adipiscing elit, proin convallis cubilia sodales, hac dis aenean platea. Hac curabitur quisque per conubia vitae, aenean pharetra facilisi lectus, taciti massa mi cum. ";

// Referencia al contenedor principal de resultados
const contenedor = document.getElementById('contenedorResultado');

/**
 * Función que inserta contenido con formato accesible.
 */
function mostrarContenido(titulo, parrafo, imagenes = []) {
    contenedor.innerHTML = `<h2>${titulo}</h2>`;
    contenedor.innerHTML += `<p>${parrafo}</p>`;
    
    // Contenedor de imágenes (WCAG 1.3.1 - Estructura)
    const divImagenes = document.createElement('div');
    divImagenes.style.display = 'flex';
    divImagenes.style.gap = '10px';
    divImagenes.style.flexWrap = 'wrap'; 
    divImagenes.style.marginTop = '15px';

    imagenes.forEach(imgData => {
        const imgElemento = document.createElement('img');
        imgElemento.src = imgData.url;
        imgElemento.alt = imgData.alt; // Atributo ALT (WCAG 1.1.1)
        imgElemento.style.width = '30%'; 
        imgElemento.style.height = 'auto';
        imgElemento.style.border = '1px solid #0056b3';
        divImagenes.appendChild(imgElemento);
    });
    
    contenedor.appendChild(divImagenes);
}


// -----------------------------------------------------------
// Lógica de TERCER NIVEL
// -----------------------------------------------------------

function manejarEleccionClimaPortugal(opcion) {
    contenedor.innerHTML = '';
    
    switch (opcion.toLowerCase()) {
        case 'turismo':
            mostrarContenido("🇵🇹 Turismo en Portugal: Lisboa", 
                             LOREM + " Texto descriptivo de los atractivos turísticos de Portugal.", 
                             IMAGENES.pt_turismo);
            break;
        case 'playa':
            mostrarContenido("🇵🇹 Playa en Portugal: El Algarve", 
                             LOREM + " El Algarve es famoso por sus playas y formaciones rocosas.", 
                             IMAGENES.pt_playa);
            break;
        case 'montaña':
            mostrarContenido("🇵🇹 Montaña/Peregrinación en Portugal: Fátima y Nazaré", 
                             LOREM + " La montaña puede referirse a áreas de peregrinación o vistas altas, como Nazaré y Fátima.", 
                             IMAGENES.pt_montana);
            break;
        default:
            contenedor.innerHTML = "<p class='error'>Opción de Portugal no válida.</p>";
            break;
    }
}

function manejarEleccionClimaEspana(clima) {
    contenedor.innerHTML = '';
    
    switch (clima.toLowerCase()) {
        case 'playa':
            mostrarContenido("🇪🇸 Tu Destino: España - Playa", 
                             LOREM + " Disfruta de las mejores playas del Mediterráneo y el Atlántico.", 
                             IMAGENES.es_playa);
            break;
        case 'montaña':
            mostrarContenido("🇪🇸 Tu Destino: España - Montaña", 
                             LOREM + " Explora los impresionantes picos de los Pirineos o Sierra Nevada.", 
                             IMAGENES.es_montana);
            break;
        default:
            contenedor.innerHTML = "<p class='error'>Opción de clima no válida.</p>";
            break;
    }
}

function manejarEleccionCiudadFrancia(ciudad) {
    contenedor.innerHTML = '';
    
    switch (ciudad.toLowerCase()) {
        case 'paris':
            mostrarContenido("🇫🇷 Tu Destino: París", LOREM, IMAGENES.paris);
            break;
        case 'marsella':
            mostrarContenido("🇫🇷 Tu Destino: Marsella", LOREM, IMAGENES.marsella);
            break;
        case 'lyon':
            mostrarContenido("🇫🇷 Tu Destino: Lyon", LOREM, IMAGENES.lyon);
            break;
        default:
            contenedor.innerHTML = "<p class='error'>Opción de ciudad no válida.</p>";
            break;
    }
}

// -----------------------------------------------------------
// Lógica de SEGUNDO NIVEL: Maneja la elección del país
// -----------------------------------------------------------
function manejarEleccionPais(event) {
    event.preventDefault();
    const pais = document.getElementById('inputPais').value.toLowerCase().trim();
    contenedor.innerHTML = ''; 
    
    const formPrincipal = document.getElementById('formPrincipal');

    switch (pais) {
        case 'francia':
            formPrincipal.outerHTML = `
                <form id="formSecundario" class="menu-activo">
                    <label for="inputCiudad">🇫🇷 Elige una ciudad: ¿París, Marsella o Lyon?</label>
                    <input type="text" id="inputCiudad" required placeholder="París">
                    <button type="submit">Elegir Ciudad</button>
                </form>
            `;
            document.getElementById('formSecundario').addEventListener('submit', (e) => {
                e.preventDefault();
                const ciudad = document.getElementById('inputCiudad').value;
                manejarEleccionCiudadFrancia(ciudad);
            });
            break;
            
        case 'españa':
            formPrincipal.outerHTML = `
                <form id="formSecundario" class="menu-activo">
                    <label for="inputClimaEspana">🇪🇸 Elige una opción: ¿Playa o Montaña?</label>
                    <input type="text" id="inputClimaEspana" required placeholder="Playa o Montaña">
                    <button type="submit">Elegir Opción</button>
                </form>
            `;
            document.getElementById('formSecundario').addEventListener('submit', (e) => {
                e.preventDefault();
                const clima = document.getElementById('inputClimaEspana').value;
                manejarEleccionClimaEspana(clima);
            });
            break;
            
        case 'portugal':
            formPrincipal.outerHTML = `
                <form id="formSecundario" class="menu-activo">
                    <label for="inputOpcionPortugal">🇵🇹 Elige una opción: ¿Turismo, Playa o Montaña?</label>
                    <input type="text" id="inputOpcionPortugal" required placeholder="Turismo">
                    <button type="submit">Elegir Opción</button>
                </form>
            `;
            document.getElementById('formSecundario').addEventListener('submit', (e) => {
                e.preventDefault();
                const opcion = document.getElementById('inputOpcionPortugal').value;
                manejarEleccionClimaPortugal(opcion);
            });
            break;

        default:
            contenedor.innerHTML = "<p class='error'>Opción de país no válida.</p>";
            break;
    }
}

// -----------------------------------------------------------
// Lógica de PRIMER NIVEL: Maneja el inicio (SI/NO)
// -----------------------------------------------------------
function manejarInicio(event) {
    event.preventDefault();
    
    const respuesta = document.getElementById('inputInicio').value.toLowerCase().trim();
    const tituloInicio = document.getElementById('tituloPrincipal');
    const formPrincipal = document.getElementById('formPrincipal');
    
    contenedor.innerHTML = '';

    switch (respuesta) {
        case 'si':
            tituloInicio.innerHTML = "<h2>Elige un destino: ¿Francia, España, Portugal?</h2>";
            
            formPrincipal.outerHTML = `
                <form id="formPrincipal">
                    <label for="inputPais">Introduce el país de destino:</label>
                    <input type="text" id="inputPais" required placeholder="Francia, España o Portugal">
                    <button type="submit">Elegir País</button>
                </form>
            `;
            document.getElementById('formPrincipal').addEventListener('submit', manejarEleccionPais);
            break;
            
        case 'no':
            tituloInicio.innerHTML = "<h2>Tu te lo pierdes!!! 😢</h2>";
            formPrincipal.style.display = 'none';

            const imgElemento = document.createElement('img');
            imgElemento.src = IMAGENES.perdida.url;
            imgElemento.alt = IMAGENES.perdida.alt; 
            imgElemento.style.maxWidth = '300px';
            
            contenedor.appendChild(imgElemento);
            contenedor.innerHTML += "<p style='color: red; font-weight: bold;'>Adiós! La imagen que acompaña al mensaje es para enfatizar la despedida.</p>";
            break;
            
        default:
            contenedor.innerHTML = "<p class='error'>Respuesta no válida. Por favor, introduce SI o NO.</p>";
            break;
    }
}

// Inicializar la escucha del primer nivel al cargar el DOM
document.addEventListener('DOMContentLoaded', () => {
    const formulario = document.getElementById('formPrincipal');
    formulario.addEventListener('submit', manejarInicio);
});