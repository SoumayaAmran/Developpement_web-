package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ConnectBD;
import Model.User;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/SevletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		try {
			ConnectBD cnx  = new ConnectBD();
			if ((request.getParameter("login")!=null) && (request.getParameter("password")!=null))
			{
			String login= request.getParameter("login");
			String password= request.getParameter("password");
			User e=cnx.getUser(login, password);
			if(e!=null)
			    {
				request.setAttribute("User", "");
				request.getRequestDispatcher("/produit.jsp").forward(request,response);
				}
			else
			{
				request.setAttribute("Erreur","Login ou mot de passe incorrect");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
			
			}
			
		    }catch (SQLException e1) {
			    out.println(e1.getMessage());
				e1.printStackTrace();
		}
	}
}