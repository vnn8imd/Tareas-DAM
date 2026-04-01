
const zapatillas = [
    { marca: "Nike", modelo: "Air Max Plus", talla: 40, foto: "img/nike.jpg" }, 
    { marca: "Adidas", modelo: "Superstar", talla: 38, foto: "img/adidas.jpg" }, 
    { marca: "Puma", modelo: "Puma Mirage", talla: 36, foto: "img/puma.jpg" },    
    { marca: "Nike", modelo: "Air Max Plus", talla: 40, foto: "img/nike.jpg" }, 
    { marca: "Adidas", modelo: "Superstar", talla: 38, foto: "img/adidas.jpg" }, 
    { marca: "Puma", modelo: "Puma Mirage", talla: 36, foto: "img/puma.jpg" } 
];
const contenedor = document.getElementById('catalogo');

// Recorremos el array y generamos el HTML de una sola vez
contenedor.innerHTML = zapatillas.map(zapa => `
    <div class="zapatilla-card">
        <div class="img-container">
            <img src="${zapa.foto}" alt="${zapa.marca}">
        </div>
        <h3>${zapa.marca}</h3>
        <p>Modelo: ${zapa.modelo}</p>
        <p>Talla: ${zapa.talla}</p>
    </div>
`).join('');