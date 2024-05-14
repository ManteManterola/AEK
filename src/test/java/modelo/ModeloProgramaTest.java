package modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloProgramaTest {

	@Test
	public void testGetAll() throws SQLException {
		
		// Mock de ModeloPrograma
		ModeloPrograma modeloProgramaMock = mock(ModeloPrograma.class);

		// Configurar mock
		ArrayList<Programa> programasSimulados = new ArrayList<>();
		when(modeloProgramaMock.getAll()).thenReturn(programasSimulados);

		// Ejecutar método
		ArrayList<Programa> programas = modeloProgramaMock.getAll();

		// Comprobar resultado
		assertNotNull(programas);
	}

	@Test
	public void testInsert() throws SQLException {

		// Mock de ModeloPrograma
		ModeloPrograma modeloProgramaMock = mock(ModeloPrograma.class);

		// Inventar valores para el tets
		Programa programa = new Programa();
		Curso curso = new Curso();
		programa.setContenido("texto de ejemplo");
		programa.setCriterioEvaluacion("texto de ejemplo pa los criterios de evau");
		curso.setId(3);
		programa.setCurso(curso);

		// Ejecutar método
		modeloProgramaMock.insert(programa);

		// Comprobar resultado
		verify(modeloProgramaMock, times(1)).insert(programa);
	}

	@Test
	public void testUpdate() throws SQLException {

		ModeloPrograma modeloProgramaMock = mock(ModeloPrograma.class);

		Programa programa = new Programa();
		Curso curso = new Curso();
		programa.setContenido("yo que se");
		programa.setCriterioEvaluacion("evaluacion");
		curso.setId(2);
		curso.setNivel("A2");
		programa.setCurso(curso);

		when(modeloProgramaMock.update(programa)).thenReturn(1);

		int lineasActualizadas = modeloProgramaMock.update(programa);

		assertEquals(1, lineasActualizadas);
	}

	@Test
	public void testDelete() throws SQLException {
		
		// Mock de ModeloPrograma
		ModeloPrograma modeloProgramaMock = mock(ModeloPrograma.class);

		// Ejecutar método
		modeloProgramaMock.delete(3);

		// Comprobar resultado
		verify(modeloProgramaMock, times(1)).delete(3);
	}
}
