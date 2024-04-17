DROP TABLE PROFESORES CASCADE CONSTRAINTS;
DROP TABLE CURSOS CASCADE CONSTRAINTS;
DROP TABLE PROGRAMAS CASCADE CONSTRAINTS;
DROP TABLE ALUMNOS CASCADE CONSTRAINTS;
DROP TABLE SEGUIMIENTOS CASCADE CONSTRAINTS;


CREATE TABLE PROFESORES (
id NUMBER(10),
dni NUMBER(9),
nombre VARCHAR2(25),
apellido VARCHAR2(25)
);

CREATE TABLE CURSOS (
id NUMBER(10),
nivel VARCHAR2(2),
turno VARCHAR2(25),
idProfesor NUMBER(10)
);

CREATE TABLE PROGRAMAS (
contenido VARCHAR2(3999),
criterioEvaluacion VARCHAR2(3999),
idCurso NUMBER(10)
);

CREATE TABLE ALUMNOS (
id NUMBER(10),
dni NUMBER(9),
nombre VARCHAR2(25),
apellido VARCHAR2(25),
edad NUMBER (2),
idCurso NUMBER(10)
);

CREATE TABLE SEGUIMIENTOS (
faltas NUMBER,
participacion VARCHAR (25),
rendimiento VARCHAR (25),
idAlumno NUMBER(10)
);

-- Alter table profesores --
ALTER TABLE PROFESORES 
ADD CONSTRAINT pk_profe PRIMARY KEY (id);

ALTER TABLE PROFESORES 
ADD CONSTRAINT unique_dni UNIQUE (dni);

-- Autoincrement id profesores --

-- Eliminar la secuencia (Resetear ids)-- 
DROP SEQUENCE profesores_id_seq;
------------------------------------

CREATE SEQUENCE profesores_id_seq
START WITH 1
INCREMENT BY 1;


CREATE OR REPLACE TRIGGER trg_profesores_id
BEFORE INSERT ON PROFESORES
FOR EACH ROW
BEGIN
    SELECT profesores_id_seq.NEXTVAL
    INTO :NEW.id
    FROM DUAL;
END;


--Alter table cursos --
ALTER TABLE CURSOS 
ADD CONSTRAINT pk_codigo PRIMARY KEY (id);

ALTER TABLE CURSOS 
ADD CONSTRAINT unique_nivel_turno UNIQUE (nivel, turno);

ALTER TABLE CURSOS
ADD CONSTRAINT fk_curso_profe FOREIGN KEY (idProfesor) REFERENCES PROFESORES(id);

-- Checks cursos
ALTER TABLE CURSOS
ADD CONSTRAINT chk_nivel CHECK (nivel IN ('A1', 'A2', 'B1', 'B2', 'C1', 'C2'));

ALTER TABLE CURSOS
ADD CONSTRAINT chk_turno CHECK (turno IN ('Diurno', 'Vespertino', 'Nocturno'));

-- Autoincrement id cursos --

-- Eliminar la secuencia (Resetear ids)-- 
DROP SEQUENCE cursos_id_seq;
------------------------------------

CREATE SEQUENCE cursos_id_seq
START WITH 1
INCREMENT BY 1;


CREATE OR REPLACE TRIGGER trg_cursos_id
BEFORE INSERT ON CURSOS
FOR EACH ROW
BEGIN
    SELECT cursos_id_seq.NEXTVAL
    INTO :NEW.id
    FROM DUAL;
END;
----------------------------------------------
-- Alter table programas --
ALTER TABLE PROGRAMAS
ADD CONSTRAINT fk_programa_curso FOREIGN KEY (idCurso) REFERENCES CURSOS(id);

ALTER TABLE PROGRAMAS
ADD CONSTRAINT pk_programas PRIMARY KEY (idCurso);
-- Alter table alumnos --
ALTER TABLE ALUMNOS
ADD CONSTRAINT pk_alumno PRIMARY KEY (id);

ALTER TABLE ALUMNOS 
ADD CONSTRAINT unique_dni_alumnos UNIQUE (dni);

ALTER TABLE ALUMNOS
ADD CONSTRAINT fk_alumno_curso FOREIGN KEY (idCurso) REFERENCES CURSOS(id);


-- Autoincrement id alumnos --

-- Eliminar la secuencia (Resetear ids)-- 
DROP SEQUENCE alumnos_id_seq;
------------------------------------

CREATE SEQUENCE alumnos_id_seq
START WITH 1
INCREMENT BY 1;


CREATE OR REPLACE TRIGGER trg_alumnos_id
BEFORE INSERT ON ALUMNOS
FOR EACH ROW
BEGIN
    SELECT alumnos_id_seq.NEXTVAL
    INTO :NEW.id
    FROM DUAL;
END;
----------------------------------------------
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
