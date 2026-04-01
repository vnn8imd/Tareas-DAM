document.addEventListener('DOMContentLoaded', () => {
    const body = document.body;

    const h2 = document.createElement('h2');
    h2.textContent = "Tabla de Recursos Técnicos";
    body.appendChild(h2);

    const tablaRecursos = document.createElement('table');
    tablaRecursos.style.borderCollapse = 'collapse';
    tablaRecursos.style.marginTop = '15px';
    
    // --- Datos para las Asignaturas ---
    const recursos = [
        // Fila 0: Imágenes/Íconos de los temas/recursos
        {
            tipo: 'img',
            datos: [
                { src: 'https://cdn-icons-png.flaticon.com/512/2922/2922532.png', alt: 'Icono Base de Datos', label: 'Base de Datos (SQL)' },
                { src: 'https://cdn-icons-png.flaticon.com/512/2922/2922524.png', alt: 'Icono JavaScript', label: 'JavaScript (Frontend)' },
                { src: 'https://cdn-icons-png.flaticon.com/512/2922/2922515.png', alt: 'Icono Android Studio', label: 'Android Studio (API)' }
            ]
        },
        // Fila 1: Enlaces a los documentos/sitios
        {
            tipo: 'a',
            datos: [
                { href: 'https://www.w3schools.com/sql/', text: 'Tutorial de SQL Completo' },
                { href: 'https://developer.mozilla.org/es/docs/Web/JavaScript', text: 'MDN Web Docs (Referencia JS)' },
                { href: 'https://developer.android.com/codelabs/android-room-with-a-view-kotlin', text: 'Codelab: Almacenamiento Local (Room)' }
            ]
        }
    ];

    // BUCLE EXTERNO (Bucle for para las filas)
    // Recorre el array 'recursos' (crea la fila 0 y la fila 1)
    for (let i = 0; i < recursos.length; i++) {
        const filaData = recursos[i];
        
        // **DEPURACIÓN:** Mostramos qué fila vamos a crear
        console.log(`--- [DEPURACIÓN] Creando Fila ${i} (Tipo: ${filaData.tipo}) ---`);

        const fila = document.createElement('tr'); // <tr>

        // BUCLE INTERNO (Bucle for para las celdas)
        // Recorre el array 'datos' dentro de cada fila (crea las 3 celdas)
        for (let j = 0; j < filaData.datos.length; j++) {
            const item = filaData.datos[j];
            
            // **DEPURACIÓN:** Mostramos qué dato estamos procesando
            if (filaData.tipo === 'img') {
                console.log(`  [Depurando Celda ${j}] Imagen: ${item.label}`);
            } else {
                 console.log(`  [Depurando Celda ${j}] Enlace: ${item.text}`);
            }

            const celda = document.createElement('td'); // <td>
            
            // Los estilos fueron movidos al CSS en el HTML para simplificar
            // celda.style.padding = '15px';
            // celda.style.border = '1px solid #ccc';
            // celda.style.textAlign = 'center';
            // celda.style.width = '180px'; 
            
            if (filaData.tipo === 'img') {
                const elemento = document.createElement('img');
                elemento.src = item.src; 
                elemento.alt = item.alt; 
                elemento.style.width = '64px';
                elemento.style.height = '64px'; // **CORRECCIÓN MANTENIDA**
                
                const titulo = document.createElement('p');
                titulo.appendChild(document.createTextNode(item.label));
                titulo.style.fontSize = '0.9em';
                titulo.style.fontWeight = 'bold';
                
                celda.appendChild(elemento); 
                celda.appendChild(titulo);   
            } else if (filaData.tipo === 'a') {
                const elemento = document.createElement('a');
                elemento.href = item.href; 
                elemento.target = '_blank';
                
                const texto = document.createTextNode(item.text); 
                elemento.appendChild(texto); 
                celda.appendChild(elemento);
            }

            fila.appendChild(celda);
        }

        tablaRecursos.appendChild(fila);
    }

    body.appendChild(tablaRecursos);
    console.log("Proceso de creación de tabla completado");
});