package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloCurso extends Conector{
	ModeloProfesor modeloProfesor = new ModeloProfesor();

	/**
	 * Obtiene una lista de todos los cursos almacenados en la base de datos.
	 * @return ArrayList de objetos Curso que representan todos los cursos.
	 */
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

	/**
	 * Obtiene un curso específico por su ID.
	 * @param id El ID del curso que se quiere obtener.
	 * @return Objeto Curso correspondiente al ID proporcionado, o null si no se encuentra.
	 */
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

	/**
	 * Actualiza los datos de un curso en la base de datos.
	 * @param curso Objeto Curso con los datos actualizados que se quieren almacenar.
	 * @return El número de filas afectadas por la actualización.
	 */
	public int update(Curso curso) {
	    try {
	        
	        PreparedStatement pst = this.conexion.prepareStatement("UPDATE CURSOS SET nivel = ?, turno = ?, idProfesor = ? WHERE id = ?");
	        pst.setString(1, curso.getNivel());
	        pst.setString(2, curso.getTurno());
	        pst.setInt(3, curso.getProfesor().getId());
	        pst.setInt(4, curso.getId());
	        
	        return pst.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0;
	    }
	}

	/**
	 * Elimina un curso de la base de datos por su ID.
	 * @param id El ID del curso que se quiere eliminar.
	 */
	public void delete(int id) {
	    String sql = "DELETE FROM CURSOS WHERE id=?";
	    
	    try {
	        PreparedStatement pst = conexion.prepareStatement(sql);
	        pst.setInt(1, id);
	        pst.execute();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	/**
	 * Inserta un nuevo curso en la base de datos.
	 * @param curso Objeto Curso que se va a insertar en la base de datos.
	 * @return true si la inserción fue exitosa, false si ocurrió algún error.
	 */
	public boolean insert(Curso curso) {
	    String sql = "INSERT INTO CURSOS (nivel,turno,idProfesor) VALUES (?,?,?)";
	    
	    PreparedStatement pst;
	    try {
	        pst = conexion.prepareStatement(sql);
	        
	        pst.setString(1, curso.getNivel());
	        pst.setString(2, curso.getTurno());
	        pst.setInt(3, curso.getProfesor().getId());
	        
	        pst.execute();
	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	/**
	 * Obtiene una lista de cursos que no tienen un programa asociado.
	 * @return ArrayList de objetos Curso que representan los cursos sin programa.
	 */
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

	/**
	 * Verifica si un curso tiene al menos un alumno asociado.
	 * @param idCurso ID del curso que se quiere verificar.
	 * @return true si el curso tiene al menos un alumno, false si no tiene ninguno.
	 */
	public boolean tieneAlgunAlumno(int idCurso) {
	    try {
	        PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM ALUMNOS WHERE idCurso=?");
	        pst.setInt(1, idCurso);
	        ResultSet rs = pst.executeQuery();
	        
	        if (rs.next()) {
	            return true;
	        } else {
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return true;
	}

	
}
