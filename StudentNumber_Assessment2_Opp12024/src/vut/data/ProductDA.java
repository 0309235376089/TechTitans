package vut.data;

import java.sql.*;
import java.util.ArrayList;


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

    public static void addProduct(ProductPD prodObj) {
        String qry = "INSERT INTO tblProducts (prodName, price, quantity, prodCode, category) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(qry);
            ps.setString(1, prodObj.getProdName());
            ps.setDouble(2, prodObj.getPrice());
            ps.setInt(3, prodObj.getQuantity());
            ps.setInt(4, prodObj.getProdCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding product.\n" + e.getMessage());
        }
    }
}