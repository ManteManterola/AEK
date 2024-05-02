-- Eliminar todos los campos de profesores
DELETE FROM PROFESORES;

-- Insertar datos en la tabla PROFESORES
INSERT INTO PROFESORES (dni, nombre, apellido) VALUES ('12345678E', 'Juan', 'Perez');
INSERT INTO PROFESORES (dni, nombre, apellido) VALUES ('98765432U', 'Maria', 'Gonzalez');
INSERT INTO PROFESORES (dni, nombre, apellido) VALUES ('45678912Q', 'Pedro', 'Sanchez');
INSERT INTO PROFESORES (dni, nombre, apellido) VALUES ('78912345S', 'Laura', 'Martinez');
INSERT INTO PROFESORES (dni, nombre, apellido) VALUES ('32165498N', 'Carlos', 'Lopez');

-- Eliminar todos los campos de cursos
DELETE FROM CURSOS;

-- Insertar datos en la tabla CURSOS
INSERT INTO CURSOS (nivel, turno, idProfesor) VALUES ('A1', 'Diurno', 1);
INSERT INTO CURSOS (nivel, turno, idProfesor) VALUES ('A2', 'Vespertino', 2);
INSERT INTO CURSOS (nivel, turno, idProfesor) VALUES ('B1', 'Nocturno', 3);
INSERT INTO CURSOS (nivel, turno, idProfesor) VALUES ('B2', 'Diurno', 4);
INSERT INTO CURSOS (nivel, turno, idProfesor) VALUES ('C1', 'Vespertino', 5);
INSERT INTO CURSOS (nivel, turno, idProfesor) VALUES ('C2', 'Nocturno', 5);

-- Eliminar todos los campos de alumnos
DELETE FROM ALUMNOS;

-- Insertar datos en la tabla ALUMNOS
INSERT INTO ALUMNOS (dni, nombre, apellido, edad, idCurso) VALUES ('12345678A', 'Juan', 'Perez', 20, 1);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad, idCurso) VALUES ('98765432X', 'Maria', 'Gonzalez', 22, 2);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad, idCurso) VALUES ('45678912Q', 'Pedro', 'Sanchez', 21, 1);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad, idCurso) VALUES ('78912345P', 'Laura', 'Martinez', 23, 3);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad, idCurso) VALUES ('32165498L', 'Carlos', 'Lopez', 20, 2);

-- Eliminar todos los campos de programas
DELETE FROM PROGRAMAS;

-- Insertar datos en la tabla PROGRAMAS
INSERT INTO PROGRAMAS (contenido, criterioEvaluacion, idCurso) VALUES ('Hola que tal estas', 'Yo bien y tu', 1);
INSERT INTO PROGRAMAS (contenido, criterioEvaluacion, idCurso) VALUES ('A ver eso de ahi', 'Aqui no hay nada', 2);

-- Eliminar todos los campos de seguimientos
DELETE FROM SEGUIMIENTOS;

-- Insertar datos en la tabla SEGUIMIENTOS
INSERT INTO SEGUIMIENTOS (faltas, participacion, rendimiento, idAlumno) VALUES (2, 'Media', 'Medio', 1);
INSERT INTO SEGUIMIENTOS (faltas, participacion, rendimiento, idAlumno) VALUES (0, 'Alta', 'Alto', 2);
INSERT INTO SEGUIMIENTOS (faltas, participacion, rendimiento, idAlumno) VALUES (5, 'Baja', 'Bajo', 3);
INSERT INTO SEGUIMIENTOS (faltas, participacion, rendimiento, idAlumno) VALUES (1, 'Media', 'Medio', 4);
INSERT INTO SEGUIMIENTOS (faltas, participacion, rendimiento, idAlumno) VALUES (3, 'Alta', 'Sobresaliente', 5);

----------------------------------------------------------------------------------------------------------------------------
-- CONSULTAS --
-- Saca todos los alumnos que no tienen seguimiento --
DELIMITER //
CREATE PROCEDURE ALUMNOSSINSEGUIMIENTO()

BEGIN
SELECT ALUMNOS.*
FROM ALUMNOS
LEFT JOIN SEGUIMIENTOS ON ALUMNOS.id = SEGUIMIENTOS.idAlumno
WHERE SEGUIMIENTOS.idAlumno IS NULL;
END//
DELIMITER ;
CALL ALUMNOSSINSEGUIMIENTO()
