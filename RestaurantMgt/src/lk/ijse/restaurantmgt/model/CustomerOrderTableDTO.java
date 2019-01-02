/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.model;

/**
 *
 * @author CHALO
 */
public class CustomerOrderTableDTO {
    private String mealId;
    private String customerId;
    private String foodName;
    private int unitPrice;
    private int mealQty;
    private int ammount;

    public CustomerOrderTableDTO() {
    }

    public CustomerOrderTableDTO(String mealId, String customerId, String foodName, int unitPrice, int mealQty, int ammount) {
        this.mealId = mealId;
        this.customerId = customerId;
        this.foodName = foodName;
        this.unitPrice = unitPrice;
        this.mealQty = mealQty;
        this.ammount = ammount;
    }

    /**
     * @return the mealId
     */
    public String getMealId() {
        return mealId;
    }

    /**
     * @param mealId the mealId to set
     */
    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the foodName
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * @param foodName the foodName to set
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * @return the unitPrice
     */
    public int getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the mealQty
     */
    public int getMealQty() {
        return mealQty;
    }

    /**
     * @param mealQty the mealQty to set
     */
    public void setMealQty(int mealQty) {
        this.mealQty = mealQty;
    }

    /**
     * @return the ammount
     */
    public int getAmmount() {
        return ammount;
    }

    /**
     * @param ammount the ammount to set
     */
    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    @Override
    public String toString() {
        return "CustomerOrderTable{" + "mealId=" + mealId + ", customerId=" + customerId + ", foodName=" + foodName + ", unitPrice=" + unitPrice + ", mealQty=" + mealQty + ", ammount=" + ammount + '}';
    }
    
    
    
}
