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
public class FoodItem {
    private String foodId;
    private String name;
    private String chefId;
    private double unitPrice;
    private int qty;

    public FoodItem() {
    }

    public FoodItem(String foodId, String name, String chefId, double unitPrice, int qty) {
        this.foodId = foodId;
        this.name = name;
        this.chefId = chefId;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    /**
     * @return the foodId
     */
    public String getFoodId() {
        return foodId;
    }

    /**
     * @param foodId the foodId to set
     */
    public void setFoodId(String foodId) {
        this.foodId = foodId;
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
     * @return the chefId
     */
    public String getChefId() {
        return chefId;
    }

    /**
     * @param chefId the chefId to set
     */
    public void setChefId(String chefId) {
        this.chefId = chefId;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "FoodItem{" + "foodId=" + foodId + ", name=" + name + ", chefId=" + chefId + ", unitPrice=" + unitPrice + ", qty=" + qty + '}';
    }
    

    
    
    
}
