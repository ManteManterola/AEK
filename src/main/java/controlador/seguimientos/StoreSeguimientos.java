package controlador.seguimientos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloAlumno;
import modelo.ModeloSeguimiento;
import modelo.Seguimiento;
import modelo.Validator;

/**
 * Servlet implementation class StoreSeguimientos
 */
@WebServlet("/StoreSeguimientos")
public class StoreSeguimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreSeguimientos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		//recibir los datos del seguimiento
		String faltas = request.getParameter("faltas");
		//Validar que faltas es un numero
		if (Validator.esNumeroEntero(faltas)==true) {
			String participacion = request.getParameter("participacion");
			String rendimiento = request.getParameter("rendimiento");
			int nota = Integer.parseInt(request.getParameter("nota"));
			int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
			
			//almacenar el seguimiento en la bbdd
			ModeloAlumno modeloAlumno = new ModeloAlumno();
			Seguimiento seguimiento = new Seguimiento();
			seguimiento.setFaltas(Integer.parseInt(faltas));
			seguimiento.setParticipacion(participacion);
			seguimiento.setRendimiento(rendimiento);
			seguimiento.setNota(nota);
			seguimiento.setAlumno(modeloAlumno.get(idAlumno));
			
			ModeloSeguimiento modeloSeguimiento = new ModeloSeguimiento();
			modeloSeguimiento.insert(seguimiento);
			response.sendRedirect("IndexSeguimientos?msg=insertOk");	
		} else {
			response.sendRedirect("IndexSeguimientos?msg=insertError");
		}
		
	}

}
