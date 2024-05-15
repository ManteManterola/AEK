package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlumnoTest {

	@Test
	public void testGetCurso() {

		Alumno alumno = new Alumno();
		Curso curso = new Curso();

		curso.setNivel("A1");

		alumno.setCurso(curso);

		assertEquals("A1", alumno.getCurso().getNivel());
	}

	@Test
	public void testGetId() {

		Alumno alumno = new Alumno();

		alumno.setId(1);

		assertEquals(1, alumno.getId());
	}

	@Test
	public void testGetDni() {

		Alumno alumno = new Alumno();

		alumno.setDni("12345678A");

		assertEquals("12345678A", alumno.getDni());
	}

	@Test
	public void testGetNombre() {

		Alumno alumno = new Alumno();

		alumno.setNombre("Juan");

		assertEquals("Juan", alumno.getNombre());
	}

	@Test
	public void testGetApellido() {

		Alumno alumno = new Alumno();

		alumno.setApellido("Perez");

		assertEquals("Perez", alumno.getApellido());
	}

	@Test
	public void testGetEdad() {

		Alumno alumno = new Alumno();

		alumno.setEdad(20);

		assertEquals(20, alumno.getEdad());
	}

}
