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

    public static void deleteProduct(ProductPD prod) throws NotFoundException{
        boolean found=false;
        for (int i = 0; i < arProduct.size()&&!found; i++) {
            if(arProduct.get(i).getProdID().equals(prod.getProdID())){
                found=true;
                arProduct.remove(i);
            }
        }
        if(!found){
            throw  new NotFoundException(stud.getProdID()+" Not found for deleting");
        }
    }
}