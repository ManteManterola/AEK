package modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ModeloCursoTest {

	@Test
	void testGetAll() throws SQLException {

		// Crear mock para poder simular la BBDD
		Connection connectionMock = mock(Connection.class);
		PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);
		
		// Configurar mock
		when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
		when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);

		// Inventar valores para el test
		when(resultSetMock.next()).thenReturn(true).thenReturn(false);
		when(resultSetMock.getInt("id")).thenReturn(1);
		when(resultSetMock.getString("nivel")).thenReturn("Intermedio");
		when(resultSetMock.getString("turno")).thenReturn("Mañana");
		when(resultSetMock.getInt("idProfesor")).thenReturn(1);

		// conectarse a la BBDD de prueba
		ModeloCurso modeloCurso = new ModeloCurso();
		modeloCurso.setConexion(connectionMock);

		// Ejecutar método 
		ArrayList<Curso> cursosSimulados = modeloCurso.getAll();

		//Comprobar resultado
		assertNotNull(cursosSimulados);
		assertFalse(cursosSimulados.isEmpty());

		for (Curso curso : cursosSimulados) {
			assertEquals(1, curso.getId());
		    assertEquals("Intermedio", curso.getNivel());
		    assertEquals("Mañana", curso.getTurno());
		    assertNotNull( curso.getProfesor());
		}
	}

	@Test
	void testGet() throws SQLException {
		Connection connectionMock = mock(Connection.class);
		PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
		when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true);
		when(resultSetMock.getInt("id")).thenReturn(1);
		when(resultSetMock.getString("nivel")).thenReturn("Intermedio");
		when(resultSetMock.getString("turno")).thenReturn("Mañana");

		ModeloCurso modeloCurso = new ModeloCurso();
		modeloCurso.setConexion(connectionMock);

		Curso curso = modeloCurso.get(1);

		assertNotNull(curso);
		assertNotNull(curso.getId());
		assertNotNull(curso.getNivel());
		assertNotNull(curso.getTurno());
	}

	@Test
	void testUpdate() throws SQLException {
		Connection connectionMock = mock(Connection.class);
		PreparedStatement preparedStatementMock = mock(PreparedStatement.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
		when(preparedStatementMock.executeUpdate()).thenReturn(1);

		ModeloCurso modeloCurso = new ModeloCurso();
		modeloCurso.setConexion(connectionMock);

		Curso curso = new Curso();
		curso.setId(1);
		curso.setNivel("Avanzado");
		curso.setTurno("Tarde");
		Profesor profesor = new Profesor();
		profesor.setId(68);
		curso.setProfesor(profesor);

		int rowsAffected = modeloCurso.update(curso);

		assertEquals(1, rowsAffected);
	}

	@Test
	void testDelete() throws SQLException {
		Connection connectionMock = mock(Connection.class);
		PreparedStatement preparedStatementMock = mock(PreparedStatement.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);

		ModeloCurso modeloCurso = new ModeloCurso();
		modeloCurso.setConexion(connectionMock);

		modeloCurso.delete(1);

		verify(preparedStatementMock).execute();
	}

	@Test
	void testInsert() throws SQLException {
		Connection connectionMock = mock(Connection.class);
		PreparedStatement preparedStatementMock = mock(PreparedStatement.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);

		ModeloCurso modeloCurso = new ModeloCurso();
		modeloCurso.setConexion(connectionMock);

		Curso curso = new Curso();
		curso.setNivel("Avanzado");
		curso.setTurno("Tarde");
		Profesor profesor = new Profesor();
		profesor.setId(8);
		curso.setProfesor(profesor);

		modeloCurso.insert(curso);

		verify(preparedStatementMock).execute();
	}

	@Test
	void testCursosSinPrograma() throws SQLException {
		Connection connectionMock = mock(Connection.class);
		PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		when(connectionMock.createStatement()).thenReturn(preparedStatementMock);
		when(preparedStatementMock.executeQuery(anyString())).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true, false);
		when(resultSetMock.getInt("id")).thenReturn(1);
		when(resultSetMock.getString("nivel")).thenReturn("Intermedio");
		when(resultSetMock.getString("turno")).thenReturn("Mañana");

		ModeloCurso modeloCurso = new ModeloCurso();
		modeloCurso.setConexion(connectionMock);

		ArrayList<Curso> cursos = modeloCurso.cursosSinPrograma();

		assertNotNull(cursos);
		assertFalse(cursos.isEmpty());

		for (Curso curso : cursos) {
			assertNotNull(curso.getId());
			assertNotNull(curso.getNivel());
			assertNotNull(curso.getTurno());
		}
	}
}
