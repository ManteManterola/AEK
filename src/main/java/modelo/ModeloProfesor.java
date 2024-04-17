package modelo;

import java.sql.*;
import java.util.*;

public class ModeloProfesor extends Conector{

	public ArrayList<Profesor> getAll(){
		ArrayList<Profesor> profesores = new ArrayList<>();
		String sql = "SELECT * FROM PROFESORES";
		
		try {
			ResultSet rs = conexion.createStatement().executeQuery(sql);
			
			while(rs.next()) {
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
	
	public void insertarProfesor(Profesor profesor) {
		String sql = "INSERT INTO PROFESORES (dni,nombre,apellido) VALUES (?,?,?)";
		
		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, profesor.getDni());
			pst.setString(2, profesor.getNombre());
			pst.setString(3, profesor.getApellido());
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteProfesor(String dni) {
		String sql = "DELETE FROM PROFESORES WHERE dni=?";
		
		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, dni);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
