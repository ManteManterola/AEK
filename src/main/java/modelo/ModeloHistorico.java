package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloHistorico extends Conector{
	ModeloCurso modeloCurso = new ModeloCurso();
	
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
