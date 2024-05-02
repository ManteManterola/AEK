package controlador.seguimientos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alumno;
import modelo.ModeloAlumno;
import modelo.ModeloSeguimiento;
import modelo.Seguimiento;

/**
 * Servlet implementation class IndexSeguimientos
 */
@WebServlet("/IndexSeguimientos")
public class IndexSeguimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexSeguimientos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Seguimiento> seguimientos = new ModeloSeguimiento().getAll();
		ArrayList<Alumno> alumnosSinSeguimiento = new ModeloAlumno().alumnosSinSeguimiento();
		
		request.setAttribute("alumnosSinSeguimiento", alumnosSinSeguimiento);
		request.setAttribute("seguimientos", seguimientos);
		request.getRequestDispatcher("indexSeguimiento.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
