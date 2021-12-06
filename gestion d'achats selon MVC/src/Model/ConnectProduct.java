package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
public class ConnectProduct {

    public static Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {
        String hostName = "localhost";
        String dbName = "ListeProduits";
        String userName = "root";
        String password = "";
        return getMySQLConnection(hostName, dbName, userName, password);

    }

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        return DriverManager.getConnection(connectionURL, userName, password);
    }

	public static void insertProduct(Connection conn, Produit product) {	
	}
	public static void updateProduct(Connection conn, Object produit) {	
	}
	public static Connection getStoredConnection(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void deleteProduct(Connection conn, String code) {
		// TODO Auto-generated method stub	
	}	
}
		
