package controlador.programas;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloPrograma;

/**
 * Implementación del Servlet DestroyProgramas.
 * Este servlet se encarga de eliminar un programa de la base de datos.
 */
@WebServlet("/DestroyProgramas")
public class DestroyProgramas extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * Constructor del servlet DestroyProgramas.
     */
    public DestroyProgramas() {
        super();
    }

    /**
     * Maneja las solicitudes HTTP GET.
     * 
     * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
     * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
     * @throws ServletException si se produce un error en la ejecución del servlet
     * @throws IOException      si se produce un error de entrada/salida
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibir el ID del programa a eliminar
        int id = Integer.parseInt(request.getParameter("idCurso"));
        
        // Eliminar el programa de la base de datos
        ModeloPrograma modeloPrograma = new ModeloPrograma();
        modeloPrograma.delete(id);
        
        // Redirigir a la página de índice de programas con un mensaje de éxito
        response.sendRedirect("IndexProgramas?msg=deleteOk");
    }

    /**
     * Maneja las solicitudes HTTP POST.
     * 
     * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
     * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
     * @throws ServletException si se produce un error en la ejecución del servlet
     * @throws IOException      si se produce un error de entrada/salida
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirigir las solicitudes POST a doGet
        doGet(request, response);
    }

}
