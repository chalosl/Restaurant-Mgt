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
public class FoodOrderDetailDTO {
    private String customerId;
    private String foodId;
    private String mealId;
    private int qty;
    private double total;

    public FoodOrderDetailDTO() {
    }

    public FoodOrderDetailDTO(String customerId, String foodId, String mealId, int qty, double total) {
        this.customerId = customerId;
        this.foodId = foodId;
        this.mealId = mealId;
        this.qty = qty;
        this.total = total;
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

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "FoodOrderDetailDTO{" + "customerId=" + customerId + ", foodId=" + foodId + ", mealId=" + mealId + ", qty=" + qty + ", total=" + total + '}';
    }

   
    
}
