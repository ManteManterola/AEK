package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloSeguimiento extends Conector{
	ModeloAlumno modeloAlumno = new ModeloAlumno();
	
	public ArrayList<Seguimiento> getAll() {
		ArrayList<Seguimiento> seguimientos = new ArrayList<>();
		String sql = "SELECT * FROM SEGUIMIENTOS";
		
		try {
			ResultSet rs = conexion.createStatement().executeQuery(sql);
			
			while(rs.next()) {
				Seguimiento seguimiento = new Seguimiento();
				
				seguimiento.setFaltas(rs.getInt("faltas"));
				seguimiento.setParticipacion(rs.getString("participacion"));
				seguimiento.setRendimiento(rs.getString("rendimiento"));
				seguimiento.setNota(rs.getInt("nota"));
				seguimiento.setAlumno(modeloAlumno.get(rs.getInt("idAlumno")));
				seguimientos.add(seguimiento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seguimientos;
	}
	

	
	public void insert(Seguimiento seguimiento) {
		String sql = "INSERT INTO SEGUIMIENTOS (faltas,participacion,rendimiento,nota,idAlumno) VALUES (?,?,?,?,?)";
		
		PreparedStatement pst;
		
		try {
			pst = conexion.prepareStatement(sql);
			
			pst.setInt(1, seguimiento.getFaltas());
			pst.setString(2, seguimiento.getParticipacion());
			pst.setString(3, seguimiento.getRendimiento());
			pst.setInt(4, seguimiento.getNota());
			pst.setInt(5, seguimiento.getAlumno().getId());
			
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM SEGUIMIENTOS WHERE idAlumno=?";
		try {
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int update(Seguimiento seguimiento) {
		try {
			PreparedStatement pst = this.conexion.prepareStatement("UPDATE SEGUIMIENTOS SET faltas = ?, participacion = ?, rendimiento = ?, nota = ? WHERE idAlumno = ?");
			
			pst.setInt(1, seguimiento.getFaltas());
			pst.setString(2, seguimiento.getParticipacion());
			pst.setString(3, seguimiento.getRendimiento());
			pst.setInt(4, seguimiento.getNota());
			pst.setInt(5, seguimiento.getAlumno().getId());
			
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
