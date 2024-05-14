package modelo;

import java.sql.*;
import java.util.*;

public class ModeloProfesor extends Conector {

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return profesores;
	}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insertarProfesor(Profesor profesor) {
		String sql = "INSERT INTO PROFESORES (dni,nombre,apellido) VALUES (?,?,?)";

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

	public boolean imparteAlgunCurso(int idProfesor) {

		try {
			PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM CURSOS WHERE idProfesor=?");
			pst.setInt(1, idProfesor);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;

			}

			else {
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return true;

	}
	
	public boolean checkDniRepetido(String dni) {
		try {
			PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM PROFESORES WHERE dni=?");
			pst.setString(1, dni);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				return true;

			}

			else {
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean checkDniNoHaCambiado (Profesor profesor) {
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
			return false;
		}
	}

}
