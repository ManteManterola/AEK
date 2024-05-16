package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloHistorico extends Conector {
	ModeloCurso modeloCurso = new ModeloCurso();

	/**
	 * Obtiene todos los registros de la tabla "HISTORICO" de la base de datos.
	 *
	 * @return Una lista de objetos Historico que representan los registros de la
	 *         tabla "HISTORICO".
	 */
	public ArrayList<Historico> getAll() {
		ArrayList<Historico> historicos = new ArrayList<>();
		String sql = "SELECT * FROM HISTORICO";

		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Historico historico = new Historico();

				historico.setFecha(rs.getDate("fecha"));
				historico.setCurso(modeloCurso.get(rs.getInt("idCurso")));
				historico.setMedia(rs.getDouble("media"));
				historicos.add(historico);
			}

			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return historicos;
	}

	/**
	 * Elimina un registro de la tabla "HISTORICO" que corresponde al ID de curso
	 * especificado.
	 *
	 * @param id El ID del curso cuyo registro se va a eliminar.
	 */
	public void delete(int id) {
		String sql = "DELETE FROM HISTORICO WHERE idCurso=?";

		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
