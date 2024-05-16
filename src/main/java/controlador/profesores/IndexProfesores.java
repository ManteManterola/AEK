package controlador.profesores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProfesor;
import modelo.Profesor;

/**
 * Implementaci�n del Servlet IndexProfesores.
 * Este servlet se encarga de mostrar la lista de profesores en la p�gina de �ndice de profesores.
 */
@WebServlet("/IndexProfesores")
public class IndexProfesores extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     * Constructor para el servlet IndexProfesores.
     */
    public IndexProfesores() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     * Maneja la solicitud HTTP GET para mostrar la lista de profesores.
     * 
     * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
     * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet env�a al cliente
     * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud GET
     * @throws IOException      si la solicitud GET no se puede manejar
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", request.getParameter("msg"));
        
        // Obtener la lista de todos los profesores
        ArrayList<Profesor> profesores = new ModeloProfesor().getAll();
        
        // Establecer el atributo "profesores" con la lista obtenida
        request.setAttribute("profesores", profesores);
        
        // Redireccionar la solicitud a la p�gina de �ndice de profesores
        request.getRequestDispatcher("indexProfesor.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * Maneja la solicitud HTTP POST para mostrar la lista de profesores.
     * 
     * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
     * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet env�a al cliente
     * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud POST
     * @throws IOException      si la solicitud POST no se puede manejar
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // M�todo POST no implementado, se llama al m�todo doGet para procesar la solicitud
        doGet(request, response);
    }

}
