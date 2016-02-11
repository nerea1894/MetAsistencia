DROP DATABASE IF EXISTS metasistencia;

CREATE DATABASE IF NOT EXISTS metasistencia COLLATE utf8_bin;

USE metasistencia;

CREATE TABLE IF NOT EXISTS profesor (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(20),
	contrasenya VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS asignatura (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(20),
	id_profesor INT,
	FOREIGN KEY (id_profesor) REFERENCES profesor(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS alumno (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS falta (
	fecha DATE,
	id_alumno INT,
	PRIMARY KEY (fecha,id_alumno),
	FOREIGN KEY (id_alumno) REFERENCES alumno(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS nota (
	id_asignatura INT,
	id_alumno INT,
	nota1 INT,
	nota2 INT,
	nota3 INT,
	nota_ex INT,
	PRIMARY KEY (id_asignatura, id_alumno),
	FOREIGN KEY (id_asignatura) REFERENCES asignatura(id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (id_alumno) REFERENCES alumno(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS amonestacion (
	id INT PRIMARY KEY AUTO_INCREMENT,
	motivo VARCHAR(100),
	id_asignatura INT,
	id_alumno INT,
	FOREIGN KEY (id_asignatura) REFERENCES asignatura(id) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (id_alumno) REFERENCES alumno(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Insertar registros

INSERT INTO profesor
VALUES(1,'Eloy','contra');

INSERT INTO profesor
VALUES(2,'Miriam','contra');

INSERT INTO profesor
VALUES(3,'Daniel','contra');


INSERT INTO asignatura(nombre,id_profesor)
VALUES('Acceso a datos',1);

INSERT INTO asignatura(nombre,id_profesor)
VALUES('Desarrolo de interfaces',2);

INSERT INTO asignatura(nombre,id_profesor)
VALUES('Sistemas de gestion empresarial',3);

INSERT INTO asignatura(nombre,id_profesor)
VALUES('Base de datos',1);


INSERT INTO alumno
VALUES(1,'Nerea');

INSERT INTO alumno
VALUES(2,'Adrian');

INSERT INTO alumno
VALUES(3,'Dani');

INSERT INTO alumno
VALUES(4,'Javi');

INSERT INTO alumno
VALUES(5,'Bruno');

INSERT INTO alumno
VALUES(6,'Pablo');

INSERT INTO alumno
VALUES(7,'Oriol');


INSERT INTO falta(fecha,id_alumno)
VALUES('2016-01-7',1);


INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(1,1,0,0,0,0);

INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(2,1,0,0,0,0);

INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(3,1,0,0,0,0);


INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(1,2,0,0,0,0);

INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(2,2,0,0,0,0);

INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(3,2,0,0,0,0);


INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(1,3,0,0,0,0);

INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(2,3,0,0,0,0);

INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(3,3,0,0,0,0);


INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(1,4,0,0,0,0);

INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(2,4,0,0,0,0);

INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(3,4,0,0,0,0);


INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(1,5,0,0,0,0);

INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(2,5,0,0,0,0);

INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(3,5,0,0,0,0);


INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(4,6,0,0,0,0);

INSERT INTO nota(id_asignatura,id_alumno,nota1,nota2,nota3,nota_ex)
VALUES(4,7,0,0,0,0);




INSERT INTO amonestacion(motivo,id_asignatura,id_alumno)
VALUES('Falta de respeto',1,1);

