package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloPrograma extends Conector {
	ModeloCurso modeloCurso = new ModeloCurso();

	/**
	 * Elimina los programas de estudio asociados a un curso específico en la base
	 * de datos.
	 *
	 * @param id El ID del curso del cual se eliminarán los programas de estudio.
	 */
	public void delete(int id) {
		String sql = "DELETE FROM PROGRAMAS WHERE idCurso=?";
		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Recupera todos los programas de estudio almacenados en la base de datos.
	 *
	 * @return Una lista de todos los programas de estudio.
	 */
	public ArrayList<Programa> getAll() {
		ArrayList<Programa> programas = new ArrayList<>();
		String sql = "SELECT * FROM PROGRAMAS";
		try {
			ResultSet rs = conexion.createStatement().executeQuery(sql);
			while (rs.next()) {
				Programa programa = new Programa();
				programa.setContenido(rs.getString("contenido"));
				programa.setCriterioEvaluacion(rs.getString("criterioEvaluacion"));
				programa.setContenido(rs.getString("contenido"));
				programa.setCurso(modeloCurso.get(rs.getInt("idCurso")));
				programas.add(programa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return programas;
	}

	/**
	 * Inserta un nuevo programa de estudio en la base de datos.
	 *
	 * @param programa El programa de estudio que se va a insertar.
	 * @return true si la inserción fue exitosa, false si ocurrió algún error.
	 */
	public boolean insert(Programa programa) {
		String sql = "INSERT INTO PROGRAMAS (contenido, criterioEvaluacion, idCurso) VALUES (?,?,?)";
		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, programa.getContenido());
			pst.setString(2, programa.getCriterioEvaluacion());
			pst.setInt(3, programa.getCurso().getId());
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Actualiza la información de un programa de estudio existente en la base de
	 * datos.
	 *
	 * @param programa El programa de estudio con la nueva información.
	 * @return El número de filas afectadas por la actualización.
	 */
	public int update(Programa programa) {
		try {
			PreparedStatement pst = this.conexion.prepareStatement(
					"UPDATE PROGRAMAS SET contenido = ?, criterioEvaluacion = ?, idCurso = ? WHERE idCurso = ?");
			pst.setString(1, programa.getContenido());
			pst.setString(2, programa.getCriterioEvaluacion());
			pst.setInt(3, programa.getCurso().getId());
			pst.setInt(4, programa.getCurso().getId());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
