package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CursoTest {

	@Test
	public void testGetId() {

		Curso curso = new Curso();

		curso.setId(1);

		assertEquals(1, curso.getId());
	}

	@Test
	public void testGetNivel() {

		Curso curso = new Curso();

		curso.setNivel("A1");

		assertEquals("A1", curso.getNivel());
	}

	@Test
	public void testGetTurno() {

		Curso curso = new Curso();

		curso.setTurno("Mañana");

		assertEquals("Mañana", curso.getTurno());
	}

	@Test
	public void testGetProfesor() {

		Curso curso = new Curso();

		Profesor profesor = new Profesor();
		profesor.setNombre("John");

		curso.setProfesor(profesor);

		assertEquals("John", curso.getProfesor().getNombre());
	}

}
