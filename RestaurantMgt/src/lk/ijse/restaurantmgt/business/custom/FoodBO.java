/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.business.custom;

import java.util.ArrayList;
import lk.ijse.restaurantmgt.business.SuperBO;
import lk.ijse.restaurantmgt.model.FoodItemDTO;

/**
 *
 * @author CHALO
 */
public interface FoodBO extends SuperBO{
    public boolean addFood(FoodItemDTO food)throws Exception;
    
    public boolean updateFood(FoodItemDTO food)throws Exception;
    
    public FoodItemDTO searchFood(String foodId)throws Exception;
    
    public boolean deleteFood(String foodID)throws Exception;
    
    public ArrayList<FoodItemDTO>getAllFoods()throws Exception;
    
    public ArrayList<String>getAllFoodIds()throws Exception;
    
}
