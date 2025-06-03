DROP DATABASE IF EXISTS kakegurui;
CREATE DATABASE kakegurui;
USE kakegurui;

CREATE TABLE personaje (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    role ENUM('Protagonista', 'Estudiante', 'Miembro del Consejo Estudiantil', 'Dealer') NOT NULL,
    imagen LONGTEXT,
    descripcion TEXT
);

CREATE TABLE episodio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    temporada INT NOT NULL,
    numero_episodio INT NOT NULL,
    sinopsis TEXT
);

CREATE TABLE juego (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    reglas TEXT,
    id_episodio INT NOT NULL,
    FOREIGN KEY (id_episodio) REFERENCES episodio(id) ON DELETE CASCADE
);

CREATE TABLE apuesta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_juego INT NOT NULL,
    descripcion TEXT,
    resultado TEXT,
    FOREIGN KEY (id_juego) REFERENCES juego(id) ON DELETE CASCADE
);

CREATE TABLE apostador (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_apuesta INT NOT NULL,
    id_personaje INT NOT NULL,
    item_apostado VARCHAR(100),
    resultado ENUM('Ganador', 'Perdedor', 'Empate') DEFAULT NULL,
    FOREIGN KEY (id_apuesta) REFERENCES apuesta(id) ON DELETE CASCADE,
    FOREIGN KEY (id_personaje) REFERENCES personaje(id) ON DELETE CASCADE
);
