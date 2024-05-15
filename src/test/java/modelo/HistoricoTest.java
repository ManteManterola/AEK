package modelo;


import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

public class HistoricoTest {

	@Test
	public void testGetFecha() {

		Historico historico = new Historico();

		Date fecha = Date.valueOf("2024-05-10");

		historico.setFecha(fecha);

		assertEquals(fecha, historico.getFecha());
	}

	@Test
	public void testGetCurso() {

		Historico historico = new Historico();

		Curso curso = new Curso();
		curso.setNivel("A1");

		historico.setCurso(curso);

		assertEquals("A1", historico.getCurso().getNivel());
	}

	@Test
	public void testGetMedia() {

		Historico historico = new Historico();

		historico.setMedia(8.5);

		assertEquals(8.5, historico.getMedia(), 0.01);
	}

}
