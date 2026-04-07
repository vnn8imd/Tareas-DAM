class Coche {
    constructor(marca, modelo, kilometros, anyo, precio, motor, foto, disponible) {
        this.marca = marca; 
        this.modelo = modelo;
        this.kilometros = kilometros; 
        this.anyo = anyo; 
        this.precio = precio; 
        this.motor = motor; 
        this.foto = foto; 
        this.disponible = disponible; 
    }

    pintarCoche() {
       
        const rutaImagen = `images/${this.foto}`;
        const textoDisponible = this.disponible ? "Disponible" : "No disponible";

        return `
            <div class="coche-card">
                <img src="${rutaImagen}" alt="${this.marca}" style="width:100%">
                <h3>${this.marca} ${this.modelo}</h3>
                <p>Año: ${this.anyo} | Motor: ${this.motor}</p>
                <p>KM: ${this.kilometros.toLocaleString()}</p>
                <p><strong>Precio: ${this.precio} €</strong></p>
                <p><em>Estado: ${textoDisponible}</em></p>
            </div>
        `;
    }
}

let conexion = new XMLHttpRequest();
conexion.open("GET", "tiendaCoches.json");
conexion.send();

conexion.onreadystatechange = function() {
    if(conexion.readyState == 4 && conexion.status == 200) {
        let datos = JSON.parse(conexion.responseText);
        let contenedor = document.getElementById("contenedor-coches");

        // Al usar forEach sin IF, pintamos TODOS los objetos del JSON 
        datos.forEach(item => {
            let nuevoCoche = new Coche(
                item.marca, item.modelo, item.kilometros, 
                item.anyo, item.precio, item.motor, 
                item.foto, item.disponible
            );
            contenedor.innerHTML += nuevoCoche.pintarCoche();
        });
    }
};