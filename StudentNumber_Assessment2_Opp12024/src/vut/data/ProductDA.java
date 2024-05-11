package vut.data;

import org.w3c.dom.ls.LSOutput;

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

     public static void initialise(){
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
    public static void addProduct(ProductPD prodObj) {
        String query = "INSERT INTO tblProducts (prodName, price, quantity, prodCode, category) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, prodObj.getProdName());
            ps.setDouble(2, prodObj.getPrice());
            ps.setInt(3, prodObj.getQuantity());
            ps.setInt(4, prodObj.getProdCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding product.\n" + e.getMessage());
        }
    }
    public static void replenish(int quantity, int productCode) {
        String query = "UPDATE tblProduct SET quantity = quantity + ? WHERE productCode =?";
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setInt(2, productCode);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error replenishing product.\n" + e.getMessage());
        }
    }
    
}
