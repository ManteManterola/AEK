package modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class ModeloProfesorTest {

	@Test
	public void testGetAll() {

		// Mock de modeloProfesor
		ModeloProfesor modeloProfesorMock = mock(ModeloProfesor.class);

		// Configurar mock
		ArrayList<Profesor> profesoresSimulados = new ArrayList<>();
		when(modeloProfesorMock.getAll()).thenReturn(profesoresSimulados);

		// Ejecutar método
		ArrayList<Profesor> profesores = modeloProfesorMock.getAll();

		// Comprobar resultado
		assertNotNull(profesores);
	}

	@Test
	public void testGet() {

		ModeloProfesor modeloProfesorMock = mock(ModeloProfesor.class);

		Profesor profesorSimulado = new Profesor();
		when(modeloProfesorMock.get(anyInt())).thenReturn(profesorSimulado);

		Profesor profesor = modeloProfesorMock.get(5);

		assertNotNull(profesor);
	}

	@Test
	public void testInsertarProfesor() {

		// Mock de ModeloProfesor
		ModeloProfesor modeloProfesorMock = mock(ModeloProfesor.class);

		// Inventar valores para el tets
		Profesor profesor = new Profesor();
		profesor.setDni("45194274Ñ");
		profesor.setNombre("Pepito");
		profesor.setApellido("Lopez");

		// Ejecutar método
		modeloProfesorMock.insertarProfesor(profesor);

		// Comprobar resultado
		verify(modeloProfesorMock, times(1)).insertarProfesor(profesor);
	}

	@Test
	public void testUpdate() {

		ModeloProfesor modeloProfesorMock = mock(ModeloProfesor.class);

		Profesor profesor = new Profesor();
		profesor.setId(1);
		profesor.setDni("87654321B");
		profesor.setNombre("Pedro");
		profesor.setApellido("Sanchez");

		when(modeloProfesorMock.update(profesor)).thenReturn(1);

		int lineasActualizadas = modeloProfesorMock.update(profesor);

		assertEquals(1, lineasActualizadas);
	}

	@Test
	public void testDeleteProfesor() {

		// Mock de ModeloProfesor
		ModeloProfesor modeloProfesorMock = mock(ModeloProfesor.class);

		// Ejecutar método
		modeloProfesorMock.deleteProfesor(1);

		// Comprobar resultado
		verify(modeloProfesorMock, times(1)).deleteProfesor(1);
	}

	@Test
	public void testImparteAlgunCurso() {

		// Mock de ModeloProfesor
		ModeloProfesor modeloProfesorMock = mock(ModeloProfesor.class);

		// Configurar mock
		when(modeloProfesorMock.imparteAlgunCurso(13)).thenReturn(true);

		// Ejecutar método
		boolean imparteCurso = modeloProfesorMock.imparteAlgunCurso(13);

		// Comprobar resultado
		assertTrue(imparteCurso);
	}
}
