package Model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConnectBD {

	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/gestionproduits";
    static final String USER = "root";
	static final String PASS = "root";
	static  Connection conn = null;
	static Statement stmt = null;
	
   public User getUser(String login, String password) throws SQLException
   {  
		conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
	      User e= null;
	      Statement stmt= (Statement) this.conn.createStatement();
	      String sql = "SELECT * FROM users where login='"+login+"' and password='"+password+"'";
	      ResultSet rs = stmt.executeQuery(sql);
	      while(rs.next()){
	    	e=  new User(rs.getString(2), rs.getString(3));
	      }
		return e;
	   
   }

    public ArrayList<Produit> findAllProduct() {
	// TODO Auto-generated method stub
	return null;
   }


   public static java.sql.Connection getStoredConnection(HttpServletRequest request) {
	// TODO Auto-generated method stub
	return null;
   }


}
