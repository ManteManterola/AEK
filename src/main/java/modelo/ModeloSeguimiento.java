package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloSeguimiento extends Conector{
	ModeloAlumno modeloAlumno = new ModeloAlumno();
	
	/**
	 * Obtiene una lista de todos los registros de seguimiento.
	 * @return ArrayList de objetos Seguimiento que representan todos los registros de seguimiento.
	 */
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

	/**
	 * Inserta un nuevo registro de seguimiento en la base de datos.
	 * @param seguimiento Objeto Seguimiento que se va a insertar en la base de datos.
	 */
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

	/**
	 * Elimina todos los registros de seguimiento asociados a un alumno dado su ID.
	 * @param id ID del alumno del cual se eliminarán los registros de seguimiento.
	 */
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

	/**
	 * Actualiza un registro de seguimiento en la base de datos.
	 * @param seguimiento Objeto Seguimiento con los datos actualizados que se van a guardar en la base de datos.
	 * @return El número de filas actualizadas en la base de datos.
	 */
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
