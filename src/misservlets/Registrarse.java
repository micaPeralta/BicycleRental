package misservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registrarse
 */
public class Registrarse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrarse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("registrarse.html").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password= request.getParameter("password");
		String nombre= request.getParameter("nombre");
		String domicilio= request.getParameter("domicilio");
		String apellido= request.getParameter("apellido");
		String dni= request.getParameter("dni");
		String fecha_nacimiento= request.getParameter("fecha_nacimiento");
		String sexo= request.getParameter("sexo");
		
		/* Registrar al usuario en la base de datos */
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
	

}
