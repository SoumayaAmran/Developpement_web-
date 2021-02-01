package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Produit;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns = { "/AddProduit" })
public class AddProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
	private String fournisseur;

    public AddProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/produit.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String nom = (String) request.getParameter("nom");
        String prix = (String) request.getParameter("prix");
        float prix1 = 0;
        try {
            String prixStr = null;
			prix1 = Float.parseFloat(prixStr);
        } catch (Exception e) {
        }
        Produit product = new Produit(nom , prix, fournisseur );

        String errorString = null;
        String regex = "\\w+";

        if (errorString == null) {
            Connection conn = null;
			insertProduct(conn, product);
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);

        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/produit.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/ListeProduits");
        }
    }

	private void insertProduct(Connection conn, Produit product) {
		// TODO Auto-generated method stub
		
	}
}