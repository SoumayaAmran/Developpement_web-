package Controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ConnectBD;
import Model.ConnectProduct;
import Model.Produit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = { "/editProduct" })
public class EditProduct extends HttpServlet {

    private static final long serialVersionUID = 1L;
	private String nom;
	private float prix;
	private String fournisseur;

    public EditProduct() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Connection conn = ConnectBD.getStoredConnection(request);

        String nom = request.getParameter("nom");

        Produit product = null;

        String errorString = null;

        if (errorString != null && product == null) {
            response.sendRedirect(request.getServletPath() + "/ListeProduits");
            return;
 }

        request.setAttribute("error", errorString);
        request.setAttribute("produit", product);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/editProduct.jsp");
        dispatcher.forward(request, response);

    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = ConnectBD.getStoredConnection(request);

        String nom = (String) request.getParameter("nom");
        String prix = (String) request.getParameter("prix");
        String fournisseur = (String) request.getParameter("fournisseur");
        float price = 0;
        try {
            price = Float.parseFloat(fournisseur);
        } catch (Exception e) {
        }
        

        String errorString = null;
		Object product = null;
		ConnectProduct.updateProduct(conn, product);
        request.setAttribute("error", errorString);
        request.setAttribute("produit", product);

        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/editProduct.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/ListeProduits");
        }
    }
}
