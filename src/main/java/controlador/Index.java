package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Implementación del Servlet Index
 * Este servlet maneja la solicitud inicial de la aplicación y redirige la solicitud a la página principal.
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * Constructor para el servlet Index.
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     * Maneja la solicitud HTTP GET. Redirige la solicitud a la página principal (landingPage.jsp).
     * 
     * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
     * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
     * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud GET
     * @throws IOException      si la solicitud GET no se puede manejar
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("landingPage.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * Maneja la solicitud HTTP POST. Delegado al método doGet.
     * 
     * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
     * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
     * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud POST
     * @throws IOException      si la solicitud POST no se puede manejar
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
