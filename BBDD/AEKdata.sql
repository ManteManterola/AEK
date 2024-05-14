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
INSERT INTO ALUMNOS (dni, nombre, apellido, edad, idCurso) VALUES ('11111111A', 'Ana', 'Garcia', 19, 1);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad, idCurso) VALUES ('22222222B', 'Pedro', 'Fernandez', 20, 2);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad, idCurso) VALUES ('33333333C', 'Luis', 'Rodriguez', 21, 3);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('44444444D', 'Maria', 'Lopez', 22);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('55555555E', 'Juan', 'Martinez', 23);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('66666666F', 'Laura', 'Sanchez', 24);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('77777777G', 'Carlos', 'Gonzalez', 25);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('88888888H', 'Ana', 'Perez', 26);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('99999999I', 'Pedro', 'Gomez', 27);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('10101010J', 'Luisa', 'Garcia', 28);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('12121212K', 'Marcos', 'Fernandez', 29);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('13131313L', 'Sara', 'Rodriguez', 30);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('14141414M', 'Javier', 'Lopez', 31);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('15151515N', 'Elena', 'Martinez', 32);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('16161616O', 'Pablo', 'Sanchez', 33);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('17171717P', 'Marina', 'Gonzalez', 34);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('18181818Q', 'Diego', 'Martinez', 35);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('19191919R', 'Laura', 'Lopez', 36);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('20202020S', 'Mario', 'Garcia', 37);
INSERT INTO ALUMNOS (dni, nombre, apellido, edad) VALUES ('21212121T', 'Eva', 'Fernandez', 38);


-- Eliminar todos los campos de programas
DELETE FROM PROGRAMAS;

-- Insertar datos en la tabla PROGRAMAS
INSERT INTO PROGRAMAS (contenido, criterioEvaluacion, idCurso) VALUES ('Unidad 1: Saludos y Presentaciones
- Saludar y despedirse en euskera.
- Presentarse a uno mismo y a otras personas.
- Expresar gratitud y cortesía básica.
- Números del 1 al 10.
- Vocabulario básico de personas y objetos.

Unidad 2: En el Restaurante
- Pedir comida y bebida en un restaurante.
- Expresar preferencias y gustos.
- Frases comunes para pedir y ofrecer ayuda.
- Vocabulario relacionado con alimentos y bebidas.
- Frases útiles para interactuar con el camarero.

Unidad 3: Rutinas Diarias
- Hablar sobre actividades diarias y rutinas.
- Describir la hora y los horarios.
- Expresar frecuencia de actividades.
- Verbos regulares en presente.
- Vocabulario de actividades diarias y horarios.

Unidad 4: De Compras
- Comprar en una tienda y hacer preguntas sobre productos.
- Expresar precios y cantidades.
- Vocabulario de ropa, colores y tallas.
- Expresiones para hablar sobre preferencias y necesidades.
- Frases útiles para negociar y hacer compras.', 

'Comprensión Auditiva:

- Entender instrucciones básicas y preguntas simples en euskera.
-Reconocer palabras y frases comunes en diálogos lentos y claros.

Expresión Oral:

-Presentarse y describirse de manera simple en euskera.
-Usar frases básicas para comunicarse en situaciones cotidianas, como saludar, pedir ayuda o hacer preguntas sencillas.

Comprensión Lectora:

-Comprender mensajes cortos y simples en carteles, anuncios o instrucciones escritas.
-Identificar información básica en textos breves y familiares.

Expresión Escrita:

-Escribir frases y mensajes cortos utilizando vocabulario y estructuras gramaticales aprendidas en el curso.
-Transmitir información básica de manera clara y comprensible.

Interacción Oral:

-Participar en conversaciones simples y breves en euskera.
-Ser capaz de realizar intercambios básicos en situaciones prácticas, como pedir comida en un restaurante o dar direcciones.

Cultura y Conciencia Cultural:

-Mostrar un conocimiento básico de la cultura vasca y sus tradiciones.
-Reconocer algunos aspectos culturales relevantes en el uso del lenguaje y las interacciones sociales en el contexto vasco.', 1);
INSERT INTO PROGRAMAS (contenido, criterioEvaluacion, idCurso) VALUES ('A ver eso de ahi', 'Aqui no hay nada', 2);

-- Eliminar todos los campos de seguimientos
DELETE FROM SEGUIMIENTOS;

----------------------------------------------------------------------------------------------------------------------------

