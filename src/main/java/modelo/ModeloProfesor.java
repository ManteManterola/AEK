package modelo;

import java.sql.*;
import java.util.*;

public class ModeloProfesor extends Conector {

	/**
	 * Obtiene todos los registros de la tabla "PROFESORES" de la base de datos.
	 *
	 * @return Una lista de objetos Profesor que representan los registros de la
	 *         tabla "PROFESORES".
	 */
	public ArrayList<Profesor> getAll() {
		ArrayList<Profesor> profesores = new ArrayList<>();
		String sql = "SELECT * FROM PROFESORES";

		try {
			ResultSet rs = conexion.createStatement().executeQuery(sql);

			while (rs.next()) {
				Profesor profesor = new Profesor();

				profesor.setId(rs.getInt("id"));
				profesor.setDni(rs.getString("dni"));
				profesor.setNombre(rs.getString("nombre"));
				profesor.setApellido(rs.getString("apellido"));
				profesores.add(profesor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return profesores;
	}

	/**
	 * Obtiene un registro de la tabla "PROFESORES" que corresponde al ID de
	 * profesor especificado.
	 *
	 * @param id El ID del profesor cuyo registro se va a recuperar.
	 * @return Un objeto Profesor que representa el registro de la tabla
	 *         "PROFESORES", o null si no se encuentra ningún registro con el ID
	 *         especificado.
	 */
	public Profesor get(int id) {
		try {
			PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM PROFESORES WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Profesor profesor = new Profesor();
				profesor.setId(rs.getInt("id"));
				profesor.setDni(rs.getString("dni"));
				profesor.setNombre(rs.getString("nombre"));
				profesor.setApellido(rs.getString("apellido"));

				return profesor;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Inserta un nuevo registro de profesor en la tabla "PROFESORES".
	 *
	 * @param profesor El objeto Profesor que se va a insertar en la base de datos.
	 */
	public void insertarProfesor(Profesor profesor) {
		String sql = "INSERT INTO PROFESORES (dni, nombre, apellido) VALUES (?, ?, ?)";

		try {
			PreparedStatement pst = conexion.prepareStatement(sql);

			pst.setString(1, profesor.getDni());
			pst.setString(2, profesor.getNombre());
			pst.setString(3, profesor.getApellido());

			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Elimina un registro de profesor de la tabla "PROFESORES" en la base de datos.
	 *
	 * @param id El ID del profesor cuyo registro se va a eliminar.
	 */
	public void deleteProfesor(int id) {
		String sql = "DELETE FROM PROFESORES WHERE id=?";

		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Actualiza un registro de profesor en la tabla "PROFESORES" de la base de
	 * datos.
	 *
	 * @param profesor El objeto Profesor con los nuevos valores que se van a
	 *                 actualizar en la base de datos.
	 * @return El número de filas afectadas por la actualización.
	 */
	public int update(Profesor profesor) {
		try {
			PreparedStatement pst = this.conexion
					.prepareStatement("UPDATE PROFESORES SET dni = ?, nombre = ?, apellido = ? WHERE id = ?");
			pst.setString(1, profesor.getDni());
			pst.setString(2, profesor.getNombre());
			pst.setString(3, profesor.getApellido());
			pst.setInt(4, profesor.getId());

			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Verifica si un profesor imparte algún curso en la base de datos.
	 *
	 * @param idProfesor El ID del profesor del cual se va a verificar si imparte
	 *                   algún curso.
	 * @return true si el profesor imparte al menos un curso, false de lo contrario.
	 */
	public boolean imparteAlgunCurso(int idProfesor) {
		try {
			PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM CURSOS WHERE idProfesor=?");
			pst.setInt(1, idProfesor);
			ResultSet rs = pst.executeQuery();

			return rs.next(); // Devuelve true si hay al menos una fila, es decir, si el profesor imparte
								// algún curso.

		} catch (SQLException e) {
			e.printStackTrace();
			return true; // Si ocurre un error, se devuelve true por defecto. Podría considerarse manejar
							// el error de otra forma según los requisitos.
		}
	}

	/**
	 * Verifica si un DNI dado ya existe en la base de datos de profesores.
	 *
	 * @param dni El DNI que se va a verificar si está repetido.
	 * @return true si el DNI está repetido, false de lo contrario.
	 */
	public boolean checkDniRepetido(String dni) {
		try {
			PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM PROFESORES WHERE dni=?");
			pst.setString(1, dni);
			ResultSet rs = pst.executeQuery();

			return rs.next(); // Devuelve true si hay al menos una fila, es decir, si el DNI está repetido.

		} catch (SQLException e) {
			e.printStackTrace();
			return true; // Si ocurre un error, se devuelve true por defecto. Podría considerarse manejar
							// el error de otra forma según los requisitos.
		}
	}

	/**
	 * Verifica si el DNI de un profesor ha cambiado en comparación con el DNI
	 * almacenado en la base de datos.
	 *
	 * @param profesor El profesor del cual se va a verificar si el DNI ha cambiado.
	 * @return true si el DNI del profesor no ha cambiado, false si ha cambiado o si
	 *         ocurre un error durante la verificación.
	 */
	public boolean checkDniNoHaCambiado(Profesor profesor) {
		try {
			String dniViejo = "";
			PreparedStatement pst = this.conexion.prepareStatement("SELECT dni FROM PROFESORES WHERE id=?");
			pst.setInt(1, profesor.getId());

			// Ejecutar la consulta SQL y obtener el resultado
			ResultSet rs = pst.executeQuery();

			// Verificar si se obtuvo un resultado
			if (rs.next()) {
				// Obtener el DNI del resultado y almacenarlo en la variable dniViejo
				dniViejo = rs.getString("dni");
			}

			// Verificar si el DNI viejo es igual al DNI del profesor
			if (dniViejo != null && dniViejo.equals(profesor.getDni())) {
				// El DNI no ha cambiado
				return true;
			} else {
				// El DNI ha cambiado
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false; // Devuelve false si ocurre un error durante la verificación
		}
	}

}
