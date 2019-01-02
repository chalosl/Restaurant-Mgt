/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.model;

import java.util.ArrayList;

/**
 *
 * @author CHALO
 */
public class MealOrderDTO {
    private String mealId;
    private String date;
    private double totalM;
    private FoodOrderDetailDTO getFoodOrderDetailDTO;

    public MealOrderDTO() {
    }

    public MealOrderDTO(String mealId, String date, double totalM, FoodOrderDetailDTO getFoodOrderDetailDTO) {
        this.mealId = mealId;
        this.date = date;
        this.totalM = totalM;
        this.getFoodOrderDetailDTO = getFoodOrderDetailDTO;
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

    /**
     * @return the getFoodOrderDetailDTO
     */
    public FoodOrderDetailDTO getGetFoodOrderDetailDTO() {
        return getFoodOrderDetailDTO;
    }

    /**
     * @param getFoodOrderDetailDTO the getFoodOrderDetailDTO to set
     */
    public void setGetFoodOrderDetailDTO(FoodOrderDetailDTO getFoodOrderDetailDTO) {
        this.getFoodOrderDetailDTO = getFoodOrderDetailDTO;
    }

    
}
