package modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ModeloHistoricoTest {



	@Test
	void testDelete() throws SQLException {

		// Crear mock para poder simular la BBDD
		Connection connectionMock = mock(Connection.class);
		PreparedStatement preparedStatementMock = mock(PreparedStatement.class);

		// Configurar el mock
		when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);

		// conectarse a la BBDD de prueba
		ModeloHistorico modeloHistorico = new ModeloHistorico();
		modeloHistorico.setConexion(connectionMock);

		// ejecutar metodo
		int idCurso = 1;
		modeloHistorico.delete(idCurso);

		// Comprobar resultado
		verify(preparedStatementMock).execute();
	}
}
