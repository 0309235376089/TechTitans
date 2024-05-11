package vut.data;

import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import static ProductDA.ps;


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
} //whatever wow git add
//Method to delete
public static void deleteProduct(ProductPD prod) throws NotFoundException{
    boolean found=false;
    for (int i = 0; i < arProduct.size()&&!found; i++) {
        if(arProduct.get(i).getProdID().equals(prod.getProdID())){
            found=true;
            arProduct.remove(i);
        }
    }
    if(!found){
        throw  new NotFoundException(stud.getProdID() +" Not found for deleting");
    }
}

}