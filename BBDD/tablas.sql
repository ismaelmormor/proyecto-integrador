DROP TABLE IF EXISTS ALUMNO;
DROP TABLE IF EXISTS PROYECTO_INTEGRADOR;
DROP TABLE IF EXISTS AREAS;
DROP TABLE IF EXISTS USUARIOS;

CREATE TABLE AREAS(
	ID_AREA INT(3) AUTO_INCREMENT,
    Nombre VARCHAR(50),
    Descripcion VARCHAR(500),
    CONSTRAINT area_pk PRIMARY KEY (ID_AREA)
);

CREATE TABLE PROYECTO_INTEGRADOR(
	ID_Proyecto INT(3) AUTO_INCREMENT,
    Nombre VARCHAR(50),
    Curso VARCHAR(2),
    Grupo VARCHAR(50),
    Año VARCHAR(4),
    url VARCHAR(100),
    Nota INT(2),
    ID_AREA INT(3),
    CONSTRAINT proyecto_pk  PRIMARY KEY (ID_Proyecto),
    CONSTRAINT proyecto_area_fk FOREIGN KEY (ID_AREA) REFERENCES AREAS(ID_AREA)
);

CREATE TABLE ALUMNO(
	ID_Alumno INT(4) AUTO_INCREMENT,
    N_Expediente INT(9),
    Nombre VARCHAR(50),
    Apellidos VARCHAR(200),
    ID_Proyecto INT(3),
    CONSTRAINT alumno_pk PRIMARY KEY (ID_Alumno),
    CONSTRAINT proyecto_alumno_fk FOREIGN KEY (ID_Proyecto) REFERENCES PROYECTO_INTEGRADOR(ID_Proyecto)
);

CREATE TABLE USUARIOS(
	USUARIO VARCHAR(50),
	PWORD VARCHAR(50)
);

INSERT INTO USUARIOS (USUARIO, PWORD) VALUES
  ('root', 'root'),
  ('Ismael', 'root'),
  ('Wei', 'root'),
  ('Gabi', 'root'),
  ('Daza', 'root');

INSERT INTO AREAS (Nombre, Descripcion) VALUES ('DAM', 'El desarrollo de aplicaciones multiplataforma
 es una estrategia que utiliza software para crear aplicaciones para las plataformas iOS y Android simultáneamente. 
 Esto permite a las empresas llegar a una base de clientes más amplia proporcionándoles una aplicación compatible con varios dispositivos.'
 );
 
INSERT INTO AREAS (Nombre, Descripcion) VALUES ('DAW', 'El Desarrollo de Aplicaciones Web es aquel que permite crear herramientas a las que
los usuarios pueden acceder a través de Internet. En la web podremos obtener información o interactuar con elementos que nos permitan 
la comunicación entre nosotros, los usuarios y la web'
);
 
INSERT INTO AREAS (Nombre, Descripcion) VALUES ('ASIR', 'La administración de sistemas informáticos en red implica organizar, instalar y 
mantener en funcionamiento los sistemas informáticos de una empresa. Esto incluye las redes de área local (LAN), las redes de área amplia (WAN), 
los segmentos de red, las intranets y otros'
);

INSERT INTO AREAS (Nombre, Descripcion) VALUES ('Videojuegos', 'El diseño de videojuegos incluye la creación de historias, personajes, metas, 
reglas y desafíos que impulsen las interacciones con otros personajes, usuarios u objetos. Se trata de definir en qué se va a convertir el juego y 
cómo se va a relacionar el jugador con todos los elementos que componen una historia interactiva.'
);

INSERT INTO AREAS (Nombre, Descripcion) VALUES ('Animación 3D', 'La animación 3D usa gráficos por computadora para que parezca que los objetos se 
mueven en un espacio tridimensional. Los artistas usan software de modelado 3D para crear los objetos. Después viene la manipulación, una representación 
virtual de un objeto o el esqueleto de un personaje.'
);

INSERT INTO PROYECTO_INTEGRADOR (Nombre, Curso, Grupo, Año, url, nota, id_area) VALUES ('Daweishine', '1º', 'DAW', '2023', 'https://github.com/ismaelmormor/proyecto-integrador', 10, 2);

INSERT INTO ALUMNO (N_Expediente, Nombre, Apellidos, ID_Proyecto) VALUES ('22299701', 'Ismael', 'Moreno Moral', 1);
INSERT INTO ALUMNO (N_Expediente, Nombre, Apellidos, ID_Proyecto) VALUES ('22240853', 'Wei', 'Xu', 1);
INSERT INTO ALUMNO (N_Expediente, Nombre, Apellidos, ID_Proyecto) VALUES ('22233901', 'Santiago', 'Daza', 1);
INSERT INTO ALUMNO (N_Expediente, Nombre, Apellidos, ID_Proyecto) VALUES ('22243501', 'Gabriel', 'Rodríguez', 1);