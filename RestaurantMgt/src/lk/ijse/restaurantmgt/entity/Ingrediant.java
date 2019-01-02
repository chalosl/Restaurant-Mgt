/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.entity;

/**
 *
 * @author CHALO
 */
public class Ingrediant {
    private String ingrediantID;
    private String name;
    private int quantity;

    public Ingrediant() {
    }

    public Ingrediant(String ingrediantID, String name, int quantity) {
        this.ingrediantID = ingrediantID;
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * @return the ingrediantID
     */
    public String getIngrediantID() {
        return ingrediantID;
    }

    /**
     * @param ingrediantID the ingrediantID to set
     */
    public void setIngrediantID(String ingrediantID) {
        this.ingrediantID = ingrediantID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ingrediant{" + "ingrediantID=" + ingrediantID + ", name=" + name + ", quantity=" + quantity + '}';
    }
    
    

   
    
    
    
    
}
