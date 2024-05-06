package modelo;

public class Programa {

	private String contenido;
	private String criterioEvaluacion;
	private Curso curso;

	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getCriterioEvaluacion() {
		return criterioEvaluacion;
	}
	public void setCriterioEvaluacion(String criterioEvaluacion) {
		this.criterioEvaluacion = criterioEvaluacion;
	}
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
