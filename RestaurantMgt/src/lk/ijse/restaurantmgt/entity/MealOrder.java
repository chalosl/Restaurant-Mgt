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
public class MealOrder {
    private String mealId;
    private String date;
    private double totalM;

    public MealOrder() {
    }

    public MealOrder(String mealId, String date, double totalM) {
        this.mealId = mealId;
        this.date = date;
        this.totalM = totalM;
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

    /**
     * @return the totalM
     */
    public double getTotalM() {
        return totalM;
    }

    /**
     * @param totalM the totalM to set
     */
    public void setTotalM(double totalM) {
        this.totalM = totalM;
    }

    @Override
    public String toString() {
        return "MealOrder{" + "mealId=" + mealId + ", date=" + date + ", totalM=" + totalM + '}';
    }

   
    
    
    
}
