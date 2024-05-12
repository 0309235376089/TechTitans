/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut.data;

/**
 *
 * @author your student number
 */
public class ProductPD {

    public enum ProdCategory {
        WEIGHT_MANAGEMENT, NUTRITIONAL_SUPPLEMENT
    };

    private String prodName;
    private double price;
    private int quantity, prodCode;
    private ProdCategory category;

    //DECLARE MISSING AATTTRIBUTE IF ANY
    
    //CODE MUTATOR FOR THE ATTRIBUTE YOU DECLARE
    
    //CODE ACCESSOR FOR THE ATTRIBUTE YOU DECLARED
    
    public ProductPD() {
    }
    //CODE FIRST CONSTRUCTOR
    public ProductPD(String prodName, ProdCategory category, int quantity, double price) {
        this.prodName = prodName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    //CODE SECOND CONSTRUCTOR
    public void setProdName(String prodName) {

        if (prodName.length() >= 3) {
            this.prodName = prodName;
        } else {
            throw new IllegalArgumentException("Name too shot " + prodName + ", Product name must have 3 characters or more");
        }
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Invalid price " + price + ", price should be greater than 0");
        }
    }

    public void setQuantity(int quantity) {

        if (quantity >= 1) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Invalid quantity " + quantity + ", Quantity cannot be zero or negative");
        }

    }

    public String getProdName() {
        return prodName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProdCode() {
        return prodCode;
    }

    //CODE THE TOSTRING METHOD OF THE CLASS AS PER THE QUESTION PAPER
    
    //CREATE METHODS TO CALL THE METHODS YOU CREATED IN THE ProductDA class.
    //Use the same names as the names of the methods in the DA class.
}
