package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloPrograma extends Conector {
	ModeloCurso modeloCurso = new ModeloCurso();
	
	
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


	public ArrayList<Programa> getAll() {
		ArrayList<Programa> programas = new ArrayList<>();
		String sql = "SELECT * FROM PROGRAMAS";
		
		try {
			ResultSet rs = conexion.createStatement().executeQuery(sql);
			
			while(rs.next()) {
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


	public boolean insert(Programa programa) {
		
		String sql = "INSERT INTO PROGRAMAS (contenido,criterioEvaluacion,idCurso) VALUES (?,?,?)";
		
		PreparedStatement pst;
		
		try {
			pst = conexion.prepareStatement(sql);
			
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


	public int update(Programa programa) {
	
		try {
			PreparedStatement pst = this.conexion.prepareStatement("UPDATE PROGRAMAS SET contenido = ?, criterioEvaluacion = ?, idCurso = ? WHERE idCurso = ?");
			
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
