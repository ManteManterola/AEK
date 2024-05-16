package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class ModeloAlumno extends Conector {

	ModeloCurso modeloCurso = new ModeloCurso();

	/**
	 * Recupera todos los alumnos de la base de datos.
	 * @return Una lista de objetos Alumno.
	 */
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

	/**
	 * Recupera una lista de alumnos que no tienen seguimiento asociado.
	 * @return Una lista de objetos Alumno.
	 */
	public ArrayList<Alumno> alumnosSinSeguimiento() {
	    ArrayList<Alumno> alumnos = new ArrayList<>();
	    String sql = "CALL ALUMNOSSINSEGUIMIENTO()";

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

	/**
	 * Recupera un alumno de la base de datos por su ID.
	 * @param id El ID del alumno.
	 * @return El objeto Alumno correspondiente, o null si no se encuentra.
	 */
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


	/**
	 * Actualiza los datos de un alumno en la base de datos.
	 * @param alumno El objeto Alumno con los datos actualizados.
	 * @return El número de filas afectadas en la base de datos.
	 */
	public int update(Alumno alumno) {
	    try {
	        PreparedStatement pst = this.conexion.prepareStatement(
	                "UPDATE ALUMNOS SET dni = ?, nombre = ?, apellido = ?, edad = ?, idCurso = ? WHERE id = ?");

	        pst.setString(1, alumno.getDni());
	        pst.setString(2, alumno.getNombre());
	        pst.setString(3, alumno.getApellido());
	        pst.setInt(4, alumno.getEdad());
	        
	        if (alumno.getCurso() != null) {
	            pst.setInt(5, alumno.getCurso().getId());
	        } else {
	            pst.setNull(5, Types.NULL);
	        }

	        pst.setInt(6, alumno.getId());

	        return pst.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0;
	    }
	}

	/**
	 * Matricula alumnos en un curso específico en la base de datos.
	 * @param idCurso El ID del curso al que se van a matricular los alumnos.
	 * @param alumnosSeleccionados Un arreglo de Strings con los IDs de los alumnos seleccionados.
	 */
	public void matricular(String idCurso, String[] alumnosSeleccionados) {
	    for (String idAlumno : alumnosSeleccionados) {
	        try {
	            PreparedStatement pst = this.conexion.prepareStatement(
	                    "UPDATE ALUMNOS SET idCurso = ? WHERE id = ?");
	            pst.setString(1, idCurso);
	            pst.setString(2, idAlumno);
	            
	            pst.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	/**
	 * Elimina un alumno de la base de datos por su ID.
	 * @param id El ID del alumno a eliminar.
	 */
	public void delete(int id) {
	    String sql = "DELETE FROM ALUMNOS WHERE id=?";

	    try {
	        PreparedStatement pst = conexion.prepareStatement(sql);
	        pst.setInt(1, id);
	        pst.execute();
	    
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * Inserta un nuevo alumno en la base de datos.
	 * @param alumno El objeto Alumno a insertar.
	 */
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
	        e.printStackTrace();
	    }
	}


	/**
	 * Obtiene una lista de alumnos que no están asignados a ningún curso.
	 * @return ArrayList de objetos Alumno que no tienen un curso asignado.
	 */
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

	/**
	 * Verifica si un DNI está repetido en la base de datos de alumnos.
	 * @param dni El DNI a verificar.
	 * @return true si el DNI está repetido, false si no lo está.
	 */
	public boolean checkDniRepetido(String dni) {
	    try {
	        PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM ALUMNOS WHERE dni=?");
	        pst.setString(1, dni);
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

	/**
	 * Verifica si el DNI de un alumno ha cambiado en comparación con el que está almacenado en la base de datos.
	 * @param alumno El objeto Alumno para el cual se realiza la verificación.
	 * @return true si el DNI no ha cambiado, false si ha cambiado.
	 */
	public boolean checkDniNoHaCambiado (Alumno alumno) {
	    try {
	        String dniViejo = "";
	        PreparedStatement pst = this.conexion.prepareStatement("SELECT dni FROM ALUMNOS WHERE id=?");
	        pst.setInt(1, alumno.getId());
	        
	        // Ejecutar la consulta SQL y obtener el resultado
	        ResultSet rs = pst.executeQuery();
	        
	        // Verificar si se obtuvo un resultado
	        if (rs.next()) {
	            // Obtener el DNI del resultado y almacenarlo en la variable dniViejo
	            dniViejo = rs.getString("dni");
	        }
	        
	        // Verificar si el DNI viejo es igual al DNI del alumno
	        if (dniViejo != null && dniViejo.equals(alumno.getDni())) {
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
