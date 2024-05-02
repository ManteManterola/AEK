package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloAlumno extends Conector {

	ModeloCurso modeloCurso = new ModeloCurso();

	public ArrayList<Alumno> getAll() {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		String sql = "SELECT * FROM ALUMNOS";

		try {
			ResultSet rs = conexion.createStatement().executeQuery(sql);

			while (rs.next()) {
				Alumno alumno = new Alumno();

				alumno.setId(rs.getInt("id"));
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellido(rs.getString("apellido"));
				alumno.setEdad(rs.getInt("edad"));
				alumno.setCurso(modeloCurso.get(rs.getInt("idCurso")));

				alumnos.add(alumno);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return alumnos;
	}

	public Alumno get(int id) {
		try {
			PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM ALUMNOS WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Alumno alumno = new Alumno();

				alumno.setId(rs.getInt("id"));
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellido(rs.getString("apellido"));
				alumno.setEdad(rs.getInt("edad"));
				alumno.setCurso(modeloCurso.get(rs.getInt("idCurso")));

				return alumno;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public int update(Alumno alumno) {
		try {

			PreparedStatement pst = this.conexion.prepareStatement(
					"UPDATE ALUMNOS SET dni = ?, nombre = ?, apellido = ?, edad = ?, idCurso = ? WHERE id = ?");

			pst.setString(1, alumno.getDni());
			pst.setString(2, alumno.getNombre());
			pst.setString(3, alumno.getApellido());
			pst.setInt(4, alumno.getEdad());
			pst.setInt(5, alumno.getCurso().getId());
			pst.setInt(6, alumno.getId());

			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM ALUMNOS WHERE id=?";

		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert(Alumno alumno) {
		String sql = "INSERT INTO ALUMNOS (dni,nombre,apellido,edad) VALUES (?,?,?,?)";

		PreparedStatement pst;
		try {
			pst = conexion.prepareStatement(sql);

			pst.setString(1, alumno.getDni());
			pst.setString(2, alumno.getNombre());
			pst.setString(3, alumno.getApellido());
			pst.setInt(4, alumno.getEdad());

			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Alumno> getAlumnosNuevos() {

		ArrayList<Alumno> alumnosNuevos = new ArrayList<>();
		String sql = "SELECT * FROM ALUMNOS WHERE idCurso IS NULL";

		try {
			ResultSet rs = conexion.createStatement().executeQuery(sql);

			while (rs.next()) {
				Alumno alumnoNuevo = new Alumno();

				alumnoNuevo.setId(rs.getInt("id"));
				alumnoNuevo.setDni(rs.getString("dni"));
				alumnoNuevo.setNombre(rs.getString("nombre"));
				alumnoNuevo.setApellido(rs.getString("apellido"));
				alumnoNuevo.setEdad(rs.getInt("edad"));

				alumnosNuevos.add(alumnoNuevo);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return alumnosNuevos;
	}

	public int asignarCurso(int idAlumno , int idCurso) {

		try {

			PreparedStatement pst = this.conexion.prepareStatement("UPDATE ALUMNOS SET  idCurso = ? WHERE id = ?");

			pst.setInt(1, idCurso);
			pst.setInt(2,idAlumno);

			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
