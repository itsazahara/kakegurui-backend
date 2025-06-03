DROP DATABASE IF EXISTS kakegurui;
CREATE DATABASE kakegurui;
USE kakegurui;

CREATE TABLE personaje (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    role ENUM('Protagonista', 'Estudiante', 'Miembro del Consejo Estudiantil', 'Dealer') NOT NULL,
    image LONGTEXT,
    descripcion TEXT
);

CREATE TABLE episodio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(150) NOT NULL,
    temporadas INT NOT NULL,
    numero_episodio INT NOT NULL,
    sinopsis TEXT
);

CREATE TABLE juego (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    reglas TEXT,
    resultado TEXT,
    id_episodio INT NOT NULL,
    FOREIGN KEY (id_episodio) REFERENCES episodio(id) ON DELETE CASCADE
);

CREATE TABLE apuestas (
	id INT PRIMARY KEY AUTO_INCREMENT,
	id_personaje INT,
	id_juego INT,
	FOREIGN KEY (id_personaje) REFERENCES personaje(id) ON DELETE CASCADE,
	FOREIGN KEY (id_juego) REFERENCES juego(id) ON DELETE CASCADE,
);


-- CREATE TABLE quotes (
--    id SERIAL PRIMARY KEY,
  --  quote TEXT NOT NULL,
  --  character_id INT REFERENCES characters(id) ON DELETE CASCADE,
  --  episode_id INT REFERENCES episodes(id) ON DELETE SET NULL
--);