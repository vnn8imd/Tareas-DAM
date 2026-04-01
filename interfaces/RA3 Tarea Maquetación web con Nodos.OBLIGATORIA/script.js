// Seleccionamos el punto de entrada
const root = document.getElementById('root');

// 1. CREACIÓN DE NODOS (HEADER)
const header = document.createElement('header');
const logo = document.createElement('img');
logo.src = "img/logo-azul-marino-viajes.jpg";
logo.className = "main-logo";
header.appendChild(logo);

// 2. CREACIÓN DE NODOS (NAV)
const nav = document.createElement('nav');
nav.className = "navbar";
const ul = document.createElement('ul');
['Inicio', 'Nosotros', 'Servicios', 'Contacto'].forEach(text => {
    const li = document.createElement('li');
    const a = document.createElement('a');
    a.href = "#";
    a.textContent = text;
    li.appendChild(a);
    ul.appendChild(li);
});
nav.appendChild(ul);

// 3. CONTENEDOR PRINCIPAL
const container = document.createElement('div');
container.className = "container";

// SECCIÓN HERO (Nodos hijos)
const section1 = document.createElement('section');
section1.className = "hero";

const heroImg = document.createElement('img');
heroImg.src = "img/articulos-808572.jpg";

const heroTextDiv = document.createElement('div');
const h3 = document.createElement('h3');
h3.textContent = "Este es el titular del div de texto";
const p1 = document.createElement('p');
p1.textContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi mollis sapien...";
const btnMore = document.createElement('button');
btnMore.className = "btn-red";
btnMore.textContent = "VER MÁS";

heroTextDiv.append(h3, p1, btnMore); // Método moderno para añadir varios nodos
section1.append(heroImg, heroTextDiv);

// SECCIÓN BANNER
const section2 = document.createElement('section');
const h2 = document.createElement('h2');
h2.textContent = "Este es el titular de la sección 2";
const bannerImg = document.createElement('img');
bannerImg.className = "banner-img";
bannerImg.src = "img/Everest.jpg";
section2.append(h2, bannerImg);

// SECCIÓN GRID (DESTINOS)
const section3 = document.createElement('section');
section3.className = "grid";

const destinos = [
    { img: "img/Viajes_Donde_Viajes_3.jpg", txt: "Destino Playa Paradisiaca" },
    { img: "img/kayak-valencia.jpeg", txt: "Aventura en Kayak Valencia" },
    { img: "img/avion.jpg", txt: "Experiencia Lujo Jet Privado" }
];

destinos.forEach(item => {
    const card = document.createElement('div');
    card.className = "card";
    const img = document.createElement('img');
    img.src = item.img;
    const p = document.createElement('p');
    p.textContent = item.txt;
    const btn = document.createElement('button');
    btn.className = "btn-red";
    btn.textContent = "COMPRAR";

    card.append(img, p, btn);
    section3.appendChild(card);
});

// 4. ENSAMBLAJE FINAL DEL DOM
container.append(section1, section2, section3);
root.append(header, nav, container);