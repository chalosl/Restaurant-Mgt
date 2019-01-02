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
public class CustomEntity {
    private String customerId;
    private String customerName;
    private String foodId;
    private String foodName;
    
    private String mealId;
    private int mealQty;
    private String date;

    public CustomEntity() {
    }

    public CustomEntity(String customerId, String customerName, String foodId, String foodName, String mealId, int mealQty, String date) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.foodId = foodId;
        this.foodName = foodName;
        this.mealId = mealId;
        this.mealQty = mealQty;
        this.date = date;
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
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
