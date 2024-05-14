package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloCurso extends Conector{
	ModeloProfesor modeloProfesor = new ModeloProfesor();

	public ArrayList<Curso> getAll() {
	    ArrayList<Curso> cursos = new ArrayList<>();
	    String sql = "SELECT * FROM CURSOS";
	    
	    try {
	        PreparedStatement pst = conexion.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            Curso curso = new Curso();
	            
	            curso.setId(rs.getInt("id"));
	            curso.setNivel(rs.getString("nivel"));
	            curso.setTurno(rs.getString("turno"));
	            curso.setProfesor(modeloProfesor.get(rs.getInt("idProfesor")));
	            cursos.add(curso);
	        }
	        
	        pst.close(); // Cerrar PreparedStatement cuando haya terminado
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return cursos;
	}

	
	public Curso get(int id) {
		try {
			PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM CURSOS WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				Curso curso = new Curso();
				
				curso.setId(rs.getInt("id"));
				curso.setNivel(rs.getString("nivel"));
				curso.setTurno(rs.getString("turno"));
				curso.setProfesor(modeloProfesor.get(rs.getInt("idProfesor")));
				
				return curso;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(Curso curso) {
		try {
			
			PreparedStatement pst = this.conexion.prepareStatement("UPDATE CURSOS SET nivel = ?, turno = ?, idProfesor = ? WHERE id = ?");
			pst.setString(1, curso.getNivel());
			pst.setString(2, curso.getTurno());
			pst.setInt(3, curso.getProfesor().getId());
			pst.setInt(4, curso.getId());
			
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM CURSOS WHERE id=?";
		
		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(Curso curso) {
		String sql = "INSERT INTO CURSOS (nivel,turno,idProfesor) VALUES (?,?,?)";
		
		PreparedStatement pst;
		try {
			pst = conexion.prepareStatement(sql);
			
			pst.setString(1, curso.getNivel());
			pst.setString(2, curso.getTurno());
			pst.setInt(3, curso.getProfesor().getId());
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public ArrayList<Curso> cursosSinPrograma() {
		ArrayList<Curso> cursos = new ArrayList<>();
		String sql = "CALL CURSOSSINPROGRAMA()";

		try {
			ResultSet rs = conexion.createStatement().executeQuery(sql);

			while (rs.next()) {
				Curso curso = new Curso();

				curso.setId(rs.getInt("id"));
				curso.setNivel(rs.getString("nivel"));
				curso.setTurno(rs.getString("turno"));
				curso.setProfesor(modeloProfesor.get(rs.getInt("idProfesor")));

				cursos.add(curso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cursos;
	}

	
	
}
