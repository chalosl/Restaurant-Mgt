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
public class RecipyDTO {
    private String foodId;
    private String foodName;
    private String ingrediantId;
    private String ingrediant_Name;

    public RecipyDTO() {
    }

    public RecipyDTO(String foodId, String foodName, String ingrediantId, String ingrediant_Name) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.ingrediantId = ingrediantId;
        this.ingrediant_Name = ingrediant_Name;
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
     * @return the ingrediantId
     */
    public String getIngrediantId() {
        return ingrediantId;
    }

    /**
     * @param ingrediantId the ingrediantId to set
     */
    public void setIngrediantId(String ingrediantId) {
        this.ingrediantId = ingrediantId;
    }

    /**
     * @return the ingrediant_Name
     */
    public String getIngrediant_Name() {
        return ingrediant_Name;
    }

    /**
     * @param ingrediant_Name the ingrediant_Name to set
     */
    public void setIngrediant_Name(String ingrediant_Name) {
        this.ingrediant_Name = ingrediant_Name;
    }

    @Override
    public String toString() {
        return "RecipyDTO{" + "foodId=" + foodId + ", foodName=" + foodName + ", ingrediantId=" + ingrediantId + ", ingrediant_Name=" + ingrediant_Name + '}';
    }
    

   }
