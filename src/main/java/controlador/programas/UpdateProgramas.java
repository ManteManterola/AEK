package controlador.programas;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloAlumno;
import modelo.ModeloCurso;
import modelo.ModeloPrograma;
import modelo.ModeloSeguimiento;
import modelo.Programa;
import modelo.Seguimiento;

/**
 * Servlet implementation class UpdateProgramas
 */
@WebServlet("/UpdateProgramas")
public class UpdateProgramas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProgramas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recibir los datos del programa
		
		String contenido = request.getParameter("contenido");
		String criterioEvaluacion = request.getParameter("criterioEvaluacion");
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		
		//almacenar el programa en la bbdd
		ModeloCurso modeloCurso = new ModeloCurso();
		Programa programa = new Programa();
		programa.setContenido(contenido);
		programa.setCriterioEvaluacion(criterioEvaluacion);
		programa.setCurso(modeloCurso.get(idCurso));
		
		ModeloPrograma modeloPrograma = new ModeloPrograma();
		modeloPrograma.update(programa);
		
		response.sendRedirect("IndexProgramas?msg=editOk");
	}

}
