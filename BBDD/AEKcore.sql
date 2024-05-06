DROP TABLE IF EXISTS HISTORICO,SEGUIMIENTOS, ALUMNOS, PROGRAMAS, CURSOS, PROFESORES;

CREATE TABLE PROFESORES (
id INT,
dni VARCHAR(9),
nombre VARCHAR(25),
apellido VARCHAR(25)
);

CREATE TABLE CURSOS (
id INT,
nivel VARCHAR(2),
turno VARCHAR(25),
idProfesor INT
);

CREATE TABLE PROGRAMAS (
contenido TEXT,
criterioEvaluacion TEXT,
idCurso INT
);

CREATE TABLE ALUMNOS (
id INT,
dni VARCHAR(9),
nombre VARCHAR(25),
apellido VARCHAR(25),
edad INT,
idCurso INT
);

CREATE TABLE SEGUIMIENTOS (
faltas INT,
participacion VARCHAR(25),
rendimiento VARCHAR(25),
nota INT default null,
idAlumno INT
);

CREATE TABLE HISTORICO (
fecha DATE,
idCurso INT,
media DOUBLE
);

-- Alter tables profesores --
ALTER TABLE PROFESORES 
ADD CONSTRAINT pk_profe PRIMARY KEY (id);

ALTER TABLE PROFESORES 
ADD CONSTRAINT unique_dni UNIQUE (dni);

ALTER TABLE PROFESORES
MODIFY COLUMN id INT AUTO_INCREMENT;
----------------------------------------------------------------------------

-- Alter table cursos --
ALTER TABLE CURSOS 
ADD CONSTRAINT pk_codigo PRIMARY KEY (id);

ALTER TABLE CURSOS 
ADD CONSTRAINT unique_nivel_turno UNIQUE (nivel, turno);

ALTER TABLE CURSOS
ADD CONSTRAINT fk_curso_profe FOREIGN KEY (idProfesor) REFERENCES PROFESORES(id);

ALTER TABLE CURSOS
MODIFY COLUMN id INT AUTO_INCREMENT;

-- Checks cursos --
ALTER TABLE CURSOS
ADD CONSTRAINT chk_nivel CHECK (nivel IN ('A1', 'A2', 'B1', 'B2', 'C1', 'C2'));

ALTER TABLE CURSOS
ADD CONSTRAINT chk_turno CHECK (turno IN ('Diurno', 'Vespertino', 'Nocturno'));
----------------------------------------------------------------------------------
-- Alter table programas --
ALTER TABLE PROGRAMAS
ADD CONSTRAINT fk_programa_curso FOREIGN KEY (idCurso) REFERENCES CURSOS(id);

ALTER TABLE PROGRAMAS
ADD CONSTRAINT pk_programas PRIMARY KEY (idCurso);
------------------------------------------------------------------------------
-- Alter table alumnos --
ALTER TABLE ALUMNOS
ADD CONSTRAINT pk_alumno PRIMARY KEY (id);

ALTER TABLE ALUMNOS 
ADD CONSTRAINT unique_dni_alumnos UNIQUE (dni);

ALTER TABLE ALUMNOS
ADD CONSTRAINT chk_edad CHECK (edad >= 16);

ALTER TABLE ALUMNOS
ADD CONSTRAINT fk_alumno_curso FOREIGN KEY (idCurso) REFERENCES CURSOS(id);

ALTER TABLE ALUMNOS
MODIFY COLUMN id INT AUTO_INCREMENT;
------------------------------------------------------------------------------
-- Alter table seguimientos --
ALTER TABLE SEGUIMIENTOS
ADD CONSTRAINT fk_seguimiento_alumno FOREIGN KEY (idAlumno) REFERENCES ALUMNOS(id);

ALTER TABLE SEGUIMIENTOS
ADD CONSTRAINT pk_seguimientos PRIMARY KEY (idAlumno);
-- Checks seguimientos --
ALTER TABLE SEGUIMIENTOS
ADD CONSTRAINT chk_participacion CHECK (participacion IN ('Baja', 'Media', 'Alta'));

ALTER TABLE SEGUIMIENTOS
ADD CONSTRAINT chk_rendimiento CHECK (rendimiento IN ('Bajo', 'Medio', 'Alto', 'Sobresaliente'));

ALTER TABLE SEGUIMIENTOS
ADD CONSTRAINT nota_check CHECK (nota >= 0 AND nota <= 10);
----------------------------------------------------------------------------------------
-- Alter table historico --
ALTER TABLE HISTORICO
ADD CONSTRAINT pk_historico PRIMARY KEY (fecha,idCurso);

ALTER TABLE HISTORICO
ADD CONSTRAINT fk_historico_curso FOREIGN KEY (idCurso) REFERENCES CURSOS(id);


