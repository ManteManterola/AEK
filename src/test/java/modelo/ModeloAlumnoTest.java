package modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ModeloAlumnoTest {

	@Test
	void testGetAll() throws SQLException {

		// Crear mock para poder simular la BBDD
		Connection connectionMock = mock(Connection.class);
		PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		// Configurar mock
		when(connectionMock.createStatement()).thenReturn(preparedStatementMock);
		when(preparedStatementMock.executeQuery(anyString())).thenReturn(resultSetMock);

		// Inventar valores para el test
		when(resultSetMock.next()).thenReturn(true).thenReturn(false);
		when(resultSetMock.getInt("id")).thenReturn(1);
		when(resultSetMock.getString("dni")).thenReturn("12345678A");
		when(resultSetMock.getString("nombre")).thenReturn("Iñaki");
		when(resultSetMock.getString("apellido")).thenReturn("Sesma");
		when(resultSetMock.getInt("edad")).thenReturn(25);
		when(resultSetMock.getInt("idCurso")).thenReturn(1);

		// Mock ModeloCurso
		ModeloCurso modeloCursoMock = mock(ModeloCurso.class);
		when(modeloCursoMock.get(anyInt())).thenReturn(new Curso());

		// Connect to the test database
		ModeloAlumno modeloAlumno = new ModeloAlumno();
		modeloAlumno.setConexion(connectionMock);
		modeloAlumno.modeloCurso = modeloCursoMock;

		// Ejecutar metodo
		ArrayList<Alumno> alumnos = modeloAlumno.getAll();

		// Comprobar resultado
		assertNotNull(alumnos);
		assertFalse(alumnos.isEmpty());

		for (Alumno alumno : alumnos) {
			assertEquals(1, alumno.getId());
			assertEquals("12345678A", alumno.getDni());
			assertEquals("Iñaki", alumno.getNombre());
			assertEquals("Sesma", alumno.getApellido());
			assertEquals(25, alumno.getEdad());
			assertNotNull(alumno.getCurso());
		}
	}

	@Test
	void testGet() throws SQLException {

		//// Crear mock para poder simular la BBDD
		Connection connectionMock = mock(Connection.class);
		PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		// Configurar mock
		when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
		when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);

		// Inventar valores para el test
		when(resultSetMock.next()).thenReturn(true);
		when(resultSetMock.getInt("id")).thenReturn(3);
		when(resultSetMock.getString("dni")).thenReturn("12345678Z");
		when(resultSetMock.getString("nombre")).thenReturn("Clark");
		when(resultSetMock.getString("apellido")).thenReturn("Kent");
		when(resultSetMock.getInt("edad")).thenReturn(25);
		when(resultSetMock.getInt("idCurso")).thenReturn(1);

		// Mock ModeloCurso
		ModeloCurso modeloCursoMock = mock(ModeloCurso.class);
		when(modeloCursoMock.get(anyInt())).thenReturn(new Curso());

		// Mock ModeloAlumno
		ModeloAlumno modeloAlumno = new ModeloAlumno();
		modeloAlumno.setConexion(connectionMock);
		modeloAlumno.modeloCurso = modeloCursoMock;

		// Ejecutar metodo
		Alumno alumno = modeloAlumno.get(1);

		// Comprobar resultado
		assertNotNull(alumno);
		assertEquals(3, alumno.getId());
		assertEquals("12345678Z", alumno.getDni());
		assertEquals("Clark", alumno.getNombre());
		assertEquals("Kent", alumno.getApellido());
		assertEquals(25, alumno.getEdad());
		assertNotNull(alumno.getCurso());
	}

	@Test
	void testUpdate() throws SQLException {

		Connection connectionMock = mock(Connection.class);
		PreparedStatement preparedStatementMock = mock(PreparedStatement.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
		when(preparedStatementMock.executeUpdate()).thenReturn(1);

		ModeloAlumno modeloAlumno = new ModeloAlumno();
		modeloAlumno.setConexion(connectionMock);

		Alumno alumno = new Alumno();
		alumno.setId(6);
		alumno.setDni("66645698Z");
		alumno.setNombre("Pedro");
		alumno.setApellido("Lopez");
		alumno.setEdad(30);
		Curso curso = new Curso();
		curso.setId(5);
		alumno.setCurso(curso);

		int lineasActualizadas = modeloAlumno.update(alumno);

		assertEquals(1, lineasActualizadas);
	}



	@Test
	void testInsert() throws SQLException {

		Connection connectionMock = mock(Connection.class);
		PreparedStatement preparedStatementMock = mock(PreparedStatement.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);

		ModeloAlumno modeloAlumno = new ModeloAlumno();
		modeloAlumno.setConexion(connectionMock);

		Alumno nuevoAlumno = new Alumno();
		nuevoAlumno.setDni("66645698Z");
		nuevoAlumno.setNombre("Juan");
		nuevoAlumno.setApellido("Pérez");
		nuevoAlumno.setEdad(30);

		modeloAlumno.insert(nuevoAlumno);

		verify(preparedStatementMock, times(1)).execute();

	}

	@Test
	void testDelete() throws SQLException {
		Connection connectionMock = mock(Connection.class);
		PreparedStatement preparedStatementMock = mock(PreparedStatement.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);

		ModeloAlumno modeloAlumno = new ModeloAlumno();
		modeloAlumno.setConexion(connectionMock);

		int idAlumno = 1;

		modeloAlumno.delete(idAlumno);

		verify(preparedStatementMock).execute();
		verify(preparedStatementMock).setInt(1, idAlumno);
	}

}
