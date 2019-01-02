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
public class FoodOrderDetail {
        private FoodDetail_PK foodDetail_PK;
        private int mealQty;
        private double ammountOrder;


    public FoodOrderDetail() {
    }

    public FoodOrderDetail(FoodDetail_PK foodDetail_PK, int mealQty,double ammountOrder) {
        this.foodDetail_PK = foodDetail_PK;
        this.mealQty = mealQty;
        this.ammountOrder = ammountOrder;
    }

    public FoodOrderDetail(String customerId, String foodId, String mealId, int mealQty, double ammountOrder) {
        this.foodDetail_PK=new FoodDetail_PK(customerId,foodId,mealId);
        this.mealQty=mealQty;
        this.ammountOrder=ammountOrder;
    }

    /**
     * @return the foodDetail_PK
     */
    public FoodDetail_PK getFoodDetail_PK() {
        return foodDetail_PK;
    }

    /**
     * @param foodDetail_PK the foodDetail_PK to set
     */
    public void setFoodDetail_PK(FoodDetail_PK foodDetail_PK) {
        this.foodDetail_PK = foodDetail_PK;
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
     * @return the ammountOrder
     */
    public double getAmmountOrder() {
        return ammountOrder;
    }

    /**
     * @param ammountOrder the ammountOrder to set
     */
    public void setAmmountOrder(double ammountOrder) {
        this.ammountOrder = ammountOrder;
    }

   
}
