package modelo;

public class Seguimiento {

	private int faltas;
	private String participacion;
	private String rendimiento;
	private Alumno alumno;

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public String getParticipacion() {
		return participacion;
	}

	public void setParticipacion(String participacion) {
		this.participacion = participacion;
	}

	public String getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(String rendimiento) {
		this.rendimiento = rendimiento;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		return "Seguimiento [faltas=" + faltas + ", participacion=" + participacion + ", rendimiento=" + rendimiento
				+ ", alumno=" + alumno + "]";
	}
	
	

}
