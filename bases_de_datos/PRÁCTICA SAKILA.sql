/*CREAMOS BASE DE DATOS sakila */
CREATE DATABASE IF NOT EXIST sakila;

/*ACTIVAMOS BASE DE DATOS*/
USE sakila;

/*CREAMOS TABLA DE BASE DE DATOS*/

CREATE TABLE actor (
    actor_id INT(5) AUTO_INCREMENT,
    nombre VARCHAR(45),
    apellido VARCHAR(45),
    ult_act TIMESTAMP,
    PRIMARY KEY (actor_id)
);

CREATE TABLE direccion (
    direccion_id INT(5) AUTO_INCREMENT,
    direccion VARCHAR(50),
    direccion2 VARCHAR(50),
    distrito VARCHAR(20),
    id_ciudad VARCHAR(5),
    cod_postal VARCHAR(10),
    tlf VARCHAR(20),
    ult_act TIMESTAMP,
    PRIMARY KEY (direccion_id)
);

CREATE TABLE categoria (
    categoria_id INT(5) AUTO_INCREMENT,
    nombre VARCHAR(25),
    ult_act TIMESTAMP,
    PRIMARY KEY (categoria_id)   
);

CREATE TABLE ciudad (
    id_ciudad INT(5) AUTO_INCREMENT,
    ciudad VARCHAR(50),
    id_pais INT (5),
    ult_act TIMESTAMP,
    PRIMARY KEY (id_ciudad)
);

CREATE TABLE pais (
    id_pais INT (5) AUTO_INCREMENT,
    pais VARCHAR(50),
    ult_act TIMESTAMP,
    PRIMARY KEY (id_pais)
);

CREATE TABLE cliente (
    id_cliente INT (5) AUTO_INCREMENT,
    id_tienda INT (5),
    nombre VARCHAR (45),
    apellido VARCHAR (45),
    email VARCHAR (50),
    direccion_id INT (5),
    activo VARCHAR (4),
    f_creacion DATETIME,
    ult_act TIMESTAMP,
    PRIMARY KEY (id_cliente)
);

CREATE TABLE pelicula (
    id_pelicula INT(5) AUTO_INCREMENT,
    titulo VARCHAR(255),
    descripcion VARCHAR(255),
    nAno YEAR,
    id_lenguaje INT(5),
    id_idioma_ori INT(5),
    duracion_alq INT(3),
    tarifa_alq DECIMAL(4,2),
    longitud INT(5),
    coste_reemplazo DECIMAL(5,2),
    calificacion VARCHAR (255),
    carac_especiales VARCHAR (255),
    ult_act TIMESTAMP,
    PRIMARY KEY (id_pelicula)
);

CREATE TABLE actor_de_cine (
    actor_id INT(5),
    id_pelicula INT(5),
    ult_act TIMESTAMP,
    PRIMARY KEY (actor_id, id_pelicula)
);

CREATE TABLE categoria_pelicula (
    id_pelicula INT (5),
    categoria_id INT (5),
    ult_act TIMESTAMP,
    PRIMARY KEY (id_pelicula, categoria_id)
);

CREATE TABLE texto_pelicula (
    id_pelicula INT(5),
    titulo VARCHAR(255),
    descripcion VARCHAR(255),
PRIMARY KEY (id_pelicula)
);

CREATE TABLE inventario (
    id_inventario INT(5) AUTO_INCREMENT,
    id_pelicula INT (5),
    id_tienda INT (5),
    ult_act TIMESTAMP,
    PRIMARY KEY (id_inventario)
);


CREATE TABLE idioma (
    id_lenguaje INT(5) AUTO_INCREMENT,
    nombre VARCHAR (45),
    ult_act TIMESTAMP,
    PRIMARY KEY (id_lenguaje)
);


CREATE TABLE pago (
    pago_id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
    cliente_id INT(5) UNSIGNED NOT NULL,
    tienda_id INT(5) UNSIGNED NOT NULL,
    rental_id INT(5) DEFAULT NULL,
    cuenta DECIMAL(5,2) NOT NULL,
    pago_dato DATETIME NOT NULL,
    ult_act TIMESTAMP,
    PRIMARY KEY (pago_id)
);

CREATE TABLE rental (
    rental_id INT(5) NOT NULL AUTO_INCREMENT,
    rental_fecha DATETIME NOT NULL,
    id_inventario INT(5) UNSIGNED NOT NULL,
    cliente_id INT(5) UNSIGNED NOT NULL,
    retorno_fecha DATETIME DEFAULT NULL,
    staff_id INT(3) UNSIGNED NOT NULL,
    ult_act TIMESTAMP,
    PRIMARY KEY (rental_id),
    UNIQUE KEY  (rental_fecha,id_inventario,cliente_id)
);

CREATE TABLE staff (
    staff_id INT(3) UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    direccion_id INT(5) UNSIGNED NOT NULL,
    picture BLOB DEFAULT NULL,
    email VARCHAR(50) DEFAULT NULL,
    tienda_id INT(5) UNSIGNED NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    nombreUsuario VARCHAR(16) NOT NULL,
    contrasena VARCHAR(40) BINARY DEFAULT NULL,
    ult_act TIMESTAMP,
    PRIMARY KEY  (staff_id)
);

CREATE TABLE store (
    store_id INT (5) UNSIGNED NOT NULL AUTO_INCREMENT,
    manager_staff_id INT(5) UNSIGNED NOT NULL,
    direccion_id_id SMALLINT UNSIGNED NOT NULL,
    ult_act TIMESTAMP,
    PRIMARY KEY  (store_id),
    UNIQUE KEY (manager_staff_id)
    
);