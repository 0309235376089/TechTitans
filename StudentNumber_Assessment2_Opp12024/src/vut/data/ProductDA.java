package vut.data;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Examiner
 */
public class ProductDA {
    //MODIFY THESE DECLARATIONS IF THEY ARE INCORRECTLY DECLARED

     private static Connection con;
     private  Statement stmt;
     private static ResultSet rs;
     private static PreparedStatement ps;
     private static ArrayList<ProductPD> arProduct = new ArrayList<>();

     public static initialise(){
         final String USERNAME = "root";
         final String PASSWORD = "";
         final String URL = "jdbc:mysql://localhost/productDB";
         final String DRIVER = "com.mysql.cj.jdbc.Driver";

         try{
             Class.forName(DRIVER);
             con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         } catch (ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(null, "Class not found!");
         } catch (SQLException ex){
             JOptionPane.showMessageDialog(null, ex.getMessage());
         }
     }
    
}