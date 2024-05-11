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
    private static Statement stmt;
     private static ResultSet rs;
     private static PreparedStatement ps;
   private static ArrayList<ProductPD> arProduct = new ArrayList<>();
    
}
public static ArrayList<ProductPD> viewAll() throws NotFoundException
{

    arProduct.clear();

    String query = "SELECT * FROM  tblProducts";

    try
    {
        // send your query to the database using ur preparedstatement and your connection object
        ps = con.prepareStatement("SELECT * FROM  tblProducts");

        // execute and store the returned query result in resultset object
        rs = ps.executeQuery();

        while (rs.next())
        {

            arProduct.add(new ProductPD(rs.getInt(1),rs.getString(2),ProductPD.ProdCategory.valueOf(rs.getString(3)),rs.getInt(4),rs.getDouble(5)));
        }
    }
    catch (SQLException ex)
    {
        throw new NotFoundException("No data retrieved \n" + ex.getMessage());
    }


    return arProduct;
}
