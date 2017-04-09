package misservlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Hashtable<String,String> logins = new Hashtable<String,String>() ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		 logins.put("user", "user");
		 logins.put("admin", "admin");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtengo los inputs del formlario
				String email=request.getParameter("email");
				String password= request.getParameter("password");
			/*	String nombre= request.getParameter("nombre");
				String domicilio= request.getParameter("domicilio");
				String apellido= request.getParameter("apellido");
				String dni= request.getParameter("dni");
				String fecha_nacimiento= request.getParameter("fecha_nacimiento");
				String sexo= request.getParameter("sexo");*/
				System.out.println(email);
				System.out.println(logins.get(email).equals(password) );
				
				if( (logins.get(email) != null ) &&  (logins.get(email).equals(password) )){
					System.out.println("Logeada exitosamente! ");
					HttpSession miSesion = request.getSession(true);
					miSesion.setAttribute("nombre",email);
					if (email== "user")	response.sendRedirect("HomeUsr");
					else 	response.sendRedirect("HomeAdmin");
				
				}
				else {
					System.out.println("Error al logearse");
					response.sendRedirect("login.html");
					}
			}

	}


